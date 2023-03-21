import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ConsultationCompteComponent } from './component/client/consultation-compte/consultation-compte.component';
import { ConsultationInfopersoComponent } from './component/client/consultation-infoperso/consultation-infoperso/consultation-infoperso.component';
import { EspaceClientComponent } from './component/client/espace-client.component';
import { ConnectionComponent } from './shared/connection/connection.component';

const routes: Routes = [
  {path:'',component:ConnectionComponent},
  {
    path:'espaceclient',
    component:EspaceClientComponent,
    loadChildren: () =>
    import('./component/client/client.module').then(
      (m) => m.ClientModule
    )
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
