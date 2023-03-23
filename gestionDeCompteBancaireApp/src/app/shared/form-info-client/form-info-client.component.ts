import { Component,Input,Output,EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Client } from 'src/app/model/client';
import { ClientHttpService } from 'src/app/service/http/client.http.service';

@Component({
  selector: 'app-form-info-client',
  templateUrl: './form-info-client.component.html',
  styleUrls: ['./form-info-client.component.css']
})
export class FormInfoClientComponent {
  formClient!: FormGroup;
  client: Client = new Client();
  isFormUpdateMode: boolean = false;
  idBanquier!: number;

  @Output()
  formSaved = new EventEmitter<Client>();

  
  constructor(private clientHttpService: ClientHttpService,  private formBuilder: FormBuilder) {}


  ngOnInit(): void {
    this.formClient = this.formBuilder.group({
      idClient: [0],
      nom: [""],
      prenom: [""],
      adressePostale: [""],
      mail: [""],
      numTel: [""],
      dateNaissance: [""],
      nationalite: [""],
      lieuNaissance: [""],
      profession: [""],
      revenu: [""]
    });
  }


  public loadFormUpdate(client : Client){
    this.isFormUpdateMode = true;
    this.client = client;
    console.log(this.client);
    this.formClient.controls['idClient'].setValue(this.client.idClient);
    this.formClient.controls['nom'].setValue(this.client.nom);
    this.formClient.controls['prenom'].setValue(this.client.prenom);
    this.formClient.controls['adressePostale'].setValue(this.client.adressePostale);
    this.formClient.controls['mail'].setValue(this.client.mail);
    this.formClient.controls['numTel'].setValue(this.client.numTel);
    this.formClient.controls['nationalite'].setValue(this.client.nationalite);
    this.formClient.controls['lieuNaissance'].setValue(this.client.lieuNaissance);
    this.formClient.controls['profession'].setValue(this.client.profession);
    this.formClient.controls['revenu'].setValue(this.client.revenu);
  }

  loadFormCreate(idBanquier: number){
    this.client = new Client()
    this.isFormUpdateMode = false;
    this.formClient.reset();
    this.idBanquier = idBanquier;
  }


  public updateClient(){
    this.clientHttpService.update$(this.formClient.value).subscribe(
      client => {
        this.client = client;
        this.formSaved.emit(this.client);
        let element: HTMLElement = document.getElementById("closeModalUpdateClient") as HTMLElement;
        element.click();
      }
    );
  }

  public addClient(){
    this.client = <Client>this.formClient.value;
    this.client.idBanquier = this.idBanquier;
    this.clientHttpService.create$(this.client).subscribe(
      client => {
        this.client = client;
        this.formSaved.emit(this.client);
        let element: HTMLElement = document.getElementById("closeModalUpdateClient") as HTMLElement;
        element.click();
      }
    );
  }
}
