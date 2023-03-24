import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Client } from 'src/app/model/client';
import { Compte } from 'src/app/model/compte';
import { ClientHttpService } from 'src/app/service/http/client.http.service';
import { CompteHttpService } from 'src/app/service/http/compte.http.service';
import { FormInfoClientComponent } from 'src/app/shared/form-info-client/form-info-client.component';
import { TableOperationClientComponent } from 'src/app/shared/table-operation-client/table-operation-client.component';

@Component({
  selector: 'app-gestion-client',
  templateUrl: './gestion-client.component.html',
  styleUrls: ['./gestion-client.component.css']
})
export class GestionClientComponent implements OnInit{
  @ViewChild(FormInfoClientComponent, {static : true}) formClient! : FormInfoClientComponent;
  @ViewChild(TableOperationClientComponent, {static : true}) tableOperationComponent! : TableOperationClientComponent;


  clients!: Array<any>;

  idBanquier! : number;

  formCompteClient!: FormGroup

  compte!: Compte;

  idCompte!: number;

  constructor(private clientHttpService: ClientHttpService, private compteHttpService: CompteHttpService, private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    const id = sessionStorage.getItem('idUser');
    this.idBanquier = id !== null ? JSON.parse(id) : 0;
    this.loadData();
    this.formCompteClient = this.formBuilder.group({
      numCompte: [0],
      dateCreation: [""],
      solde: [0],
      decouvertAutorise: [0]
    });
  }

  public loadData() {
    this.clientHttpService.retrieveByIdBanquier$(this.idBanquier).subscribe(
      data => {
        this.clients = data;
      }
    );
  }

  public loadFormCompteClient(idClient: number){
    this.compteHttpService.getMainAccount$(idClient).subscribe(
      compte => {
        this.compte = compte;
        this.idCompte = compte.id;
        this.formCompteClient.controls['numCompte'].setValue(this.compte?.id);
        this.formCompteClient.controls['dateCreation'].setValue(this.compte?.dateCreation);
        this.formCompteClient.controls['solde'].setValue(this.compte?.solde);
        this.formCompteClient.controls['decouvertAutorise'].setValue(this.compte?.decouvertAutorise);
        this.tableOperationComponent.loadOperations(compte.id);
      }
    );
  }

  public updateCompte() {
    this.compte = this.formCompteClient.value;
    this.compte.id = this.idCompte;
    this.compteHttpService.update$(this.compte?.id,this.compte).subscribe({
      next: data => {
        console.log(data);
        alert("Compte updated");
        this.loadData();
        let element: HTMLElement = document.getElementById("closeModalCompteClient") as HTMLElement;
        element.click();
      },
      error: errors => {
        console.log(errors);
      }
    });
  }


  public loadFormUpdate(idClient: number){
    const client = this.clients.find((p) => {
      return p.idClient === idClient;
    });
    this.formClient.loadFormUpdate(client, true);
  }

  public loadFormCreate(){
    this.formClient.loadFormCreate(this.idBanquier);
  }

  public onFormSave(){
    this.loadData();
    let element: HTMLElement = document.getElementById("closeModalUpdateClient") as HTMLElement;
    element.click();
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
