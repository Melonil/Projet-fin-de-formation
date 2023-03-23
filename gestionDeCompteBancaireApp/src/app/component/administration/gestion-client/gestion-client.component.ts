import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Client } from 'src/app/model/client';
import { ClientHttpService } from 'src/app/service/http/client.http.service';

@Component({
  selector: 'app-gestion-client',
  templateUrl: './gestion-client.component.html',
  styleUrls: ['./gestion-client.component.css']
})
export class GestionClientComponent implements OnInit{

  clients!: Array<any>;

  client: Client = new Client();

  idBanquier = 1;
  idClient?: number;
  nomClient?: string;
  prenomClient?: string;
  formUpdateClient!: FormGroup

  constructor(private clientHttpService: ClientHttpService,  private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.loadData();
    this.formUpdateClient = this.formBuilder.group({
      idClient: [0],
      nom: [""],
      prenom: [""],
      adressePostale: [""],
      mail: [""],
      numTel: [""],
      lieuNaissance: [""],
      profession: [""],
      revenu: [""]
    });
  }

  private loadData() {
    this.clientHttpService.retrieveByIdBanquier$(this.idBanquier).subscribe(
      data => {
        this.clients = data;
      }
    );
  }

  public loadFormUpdate(idClient: number){
    this.client = this.clients.find((p) => {
      return p.idClient === idClient;
    });
    console.log(this.client);
    this.idClient = idClient;
    this.nomClient = this.client.nom;
    this.prenomClient = this.client.prenom;
    this.formUpdateClient.controls['idClient'].setValue(this.client.idClient);
    this.formUpdateClient.controls['nom'].setValue(this.client.nom);
    this.formUpdateClient.controls['prenom'].setValue(this.client.prenom);
    this.formUpdateClient.controls['adressePostale'].setValue(this.client.adressePostale);
    this.formUpdateClient.controls['mail'].setValue(this.client.mail);
    this.formUpdateClient.controls['numTel'].setValue(this.client.numTel);
    this.formUpdateClient.controls['lieuNaissance'].setValue(this.client.lieuNaissance);
    this.formUpdateClient.controls['profession'].setValue(this.client.profession);
    this.formUpdateClient.controls['revenu'].setValue(this.client.revenu);
  }

  public updateClient(){
    this.clientHttpService.update$(this.formUpdateClient.value).subscribe(
      client => {
        this.client = client;
        this.loadData();
      }
    );
    let element: HTMLElement = document.getElementById("closeModalUpdateClient") as HTMLElement;
    element.click();
  }

  public deleteClient(id: number) {
    let rs = confirm("Etes vous sur de vouloir supprimer le client d'id : " + id + " ?");
    if (rs) {
      this.clientHttpService.delete$(id).subscribe(data => {
        console.log(data);
        this.loadData();
      },
        error => console.log(error));
    }
  }

}
