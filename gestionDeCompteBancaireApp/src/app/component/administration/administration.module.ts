import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GestionClientComponent } from './gestion-client/gestion-client.component';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { EspaceAdministrationComponent } from './espace-administration.component';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

const route:Routes = [
  {
    path: '',
    component: GestionClientComponent
  }
];

@NgModule({
  declarations: [
    HeaderMenuComponent,
    GestionClientComponent,
    EspaceAdministrationComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(route),
    ReactiveFormsModule
  ]
})
export class AdministrationModule { }
