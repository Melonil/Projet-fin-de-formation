import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Client } from 'src/app/model/client';
import { ClientHttpService } from 'src/app/service/http/client.http.service';
import { FormInfoClientComponent } from 'src/app/shared/form-info-client/form-info-client.component';

@Component({
  selector: 'app-gestion-client',
  templateUrl: './gestion-client.component.html',
  styleUrls: ['./gestion-client.component.css']
})
export class GestionClientComponent implements OnInit{
  @ViewChild(FormInfoClientComponent, {static : true}) formClient! : FormInfoClientComponent;


  clients!: Array<any>;

  idBanquier! : number;

  constructor(private clientHttpService: ClientHttpService) {}

  ngOnInit(): void {
    const id = localStorage.getItem('idUser');
    this.idBanquier = id !== null ? JSON.parse(id) : 0;
    this.loadData();
  }

  public loadData() {
    this.clientHttpService.retrieveByIdBanquier$(this.idBanquier).subscribe(
      data => {
        this.clients = data;
      }
    );
  }

  public loadFormUpdate(idClient: number){
    const client = this.clients.find((p) => {
      return p.idClient === idClient;
    });
    this.formClient.loadFormUpdate(client);
  }

  public loadFormCreate(){
    this.formClient.loadFormCreate(this.idBanquier);
  }

  



  public archiveClient(id: number) {
    let rs = confirm("Etes vous sur de vouloir archiver le client d'id : " + id + " ?");
    if (rs) {
      this.clientHttpService.archive$(id).subscribe({
        next : (data)=>{
          console.log(data);
          this.loadData();
        },
        error : (error)=>{
          console.log(error);
        }
      });
    }
  }

}
