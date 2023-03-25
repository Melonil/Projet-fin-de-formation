import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GestionClientComponent } from './gestion-client/gestion-client.component';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { EspaceAdministrationComponent } from './espace-administration.component';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { ConsultationAdmininfopersoComponent } from './consultation-admininfoperso/consultation-admininfoperso.component';

const route:Routes = [
  {
    path: '',
    component: GestionClientComponent
  },
  {
    path: 'gestionClient',
    component: GestionClientComponent
  },
  {
    path:'detailBanquier',
    component:ConsultationAdmininfopersoComponent
  }
];

@NgModule({
  declarations: [
    HeaderMenuComponent,
    GestionClientComponent,
    EspaceAdministrationComponent,
    ConsultationAdmininfopersoComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(route),
    ReactiveFormsModule,
    SharedModule
  ],
  exports: [EspaceAdministrationComponent]
})
export class AdministrationModule { }
