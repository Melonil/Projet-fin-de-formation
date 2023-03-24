import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormInfoClientComponent } from 'src/app/shared/form-info-client/form-info-client.component';
import { ConnectionComponent } from './connection/connection.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TableOperationClientComponent } from './table-operation-client/table-operation-client.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';

const route : Routes = [];
@NgModule({
    declarations: [
        FormInfoClientComponent,
        ConnectionComponent,
        TableOperationClientComponent
    ],
    imports: [
      CommonModule,
      RouterModule.forChild(route),
      ReactiveFormsModule,
      MatPaginatorModule,
      MatTableModule
    ],
    exports:[FormInfoClientComponent,TableOperationClientComponent]
  })
  export class SharedModule { }