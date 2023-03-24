import { Component,Input,OnInit,AfterViewInit,ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Operation } from 'src/app/model/operation';
import { OperationHttpService } from 'src/app/service/http/operation.http.service';


@Component({
  selector: 'app-table-operation-client',
  templateUrl: './table-operation-client.component.html',
  styleUrls: ['./table-operation-client.component.css']
})
export class TableOperationClientComponent implements OnInit,AfterViewInit {
  @ViewChild(MatPaginator, {static : true}) 
  matPaginator! : MatPaginator;
  operations :Array<Operation> = new Array();
  dataSource = new MatTableDataSource<Operation>();
  displayedColumns: string[] = ['typeOperation', 'dateOperation', 'montant'];

  constructor(private operationHttpService : OperationHttpService) { }

  ngAfterViewInit(): void {

  }

  ngOnInit(): void {
  }

  public formatDate(date : Date) : string {
    date = new Date(date);
    return date.toLocaleDateString();
  }

  public loadOperations(idCompte:number){

    this.operationHttpService.getOperations(idCompte,0,100).subscribe(
      (data) => {
        this.operations = data;
        this.dataSource.data = data;
        this.dataSource.paginator = this.matPaginator;
      }
    );
  }

}
