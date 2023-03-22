import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultationCompteComponent } from './consultation-compte/consultation-compte.component';
import { ConsultationInfopersoComponent } from './consultation-infoperso/consultation-infoperso/consultation-infoperso.component';
import { EspaceClientComponent } from './espace-client.component';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SnackbarService } from 'src/app/service/snackbar.service';
import { ConnectionComponent } from 'src/app/shared/connection/connection.component';

const routes: Routes = [
  
    {
      path:'',
      component:ConsultationCompteComponent,
    },
    {
      path:'comptebancaire',
      component:ConsultationCompteComponent
    },
    {
      path:'detailclient',
      component:ConsultationInfopersoComponent
    }
];



@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule
  ],
  declarations: [EspaceClientComponent,ConsultationCompteComponent,ConsultationInfopersoComponent,HeaderMenuComponent],
  exports:[EspaceClientComponent],
  providers:[SnackbarService]
})
export class ClientModule {}
