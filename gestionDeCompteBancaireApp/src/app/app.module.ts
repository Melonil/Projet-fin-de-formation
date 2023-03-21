import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientModule } from './component/client/client.module';
import { RouterModule } from '@angular/router';
import { ConnectionComponent } from './shared/connection/connection.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SnackbarService } from './service/snackbar.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';


@NgModule({
  declarations: [
    AppComponent,
    ConnectionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ClientModule,
    ReactiveFormsModule,
    MatSnackBarModule 
  ],
  providers: [SnackbarService],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }
