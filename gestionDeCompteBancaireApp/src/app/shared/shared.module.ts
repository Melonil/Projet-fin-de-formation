import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormInfoClientComponent } from 'src/app/shared/form-info-client/form-info-client.component';
import { ConnectionComponent } from './connection/connection.component';
import { ReactiveFormsModule } from '@angular/forms';

const route : Routes = [];
@NgModule({
    declarations: [
        FormInfoClientComponent,
        ConnectionComponent
    ],
    imports: [
      CommonModule,
      RouterModule.forChild(route),
      ReactiveFormsModule
    ],
    exports:[FormInfoClientComponent]
  })
  export class SharedModule { }