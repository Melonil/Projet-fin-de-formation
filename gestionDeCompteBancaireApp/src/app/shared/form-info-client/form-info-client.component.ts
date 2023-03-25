import { Component,Input,Output,EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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
  idClient?: number;

  isEspaceClient: Boolean = false;
  isEspaceAdmin: Boolean = false;


  @Output()
  formSaved = new EventEmitter<Client>();

  
  constructor(private clientHttpService: ClientHttpService,  private formBuilder: FormBuilder) {}


  ngOnInit(): void {
    this.formClient = this.formBuilder.group({
      numClient: [0],
      nom: ["", [Validators.required, Validators.maxLength(25)]],
      prenom: ["", [Validators.required, Validators.maxLength(25)]],
      adressePostale: ["", [Validators.required, Validators.maxLength(50)]],
      mail: ["", [Validators.required, Validators.email, Validators.maxLength(50)]],
      numTel: ["", [Validators.required, Validators.pattern("^[+][33]{1}[0-9]{10}$")]],
      dateNaissance: ["", [Validators.required]],
      nationalite: ["", [Validators.required, Validators.maxLength(25)]],
      lieuNaissance: ["", [Validators.required]],
      profession: ["", [Validators.required, Validators.maxLength(25)]],
      revenu: ["", [Validators.required]]
    });
  }


  public loadFormUpdate(client : Client, isAdmin: boolean){
    if (isAdmin == true)
      this.isEspaceAdmin = true;
    else
      this.isEspaceClient = true;
      
    this.isFormUpdateMode = true;
    this.client = client;
    this.idClient = client.idClient;
    console.log(this.client);
    this.formClient.controls['numClient'].setValue(this.client.numClient);
    this.formClient.controls['nom'].setValue(this.client.nom);
    this.formClient.controls['prenom'].setValue(this.client.prenom);
    this.formClient.controls['adressePostale'].setValue(this.client.adressePostale);
    this.formClient.controls['mail'].setValue(this.client.mail);
    this.formClient.controls['numTel'].setValue(this.client.numTel);
    this.formClient.controls['nationalite'].setValue(this.client.nationalite);
    this.formClient.controls['dateNaissance'].setValue(this.client.dateNaissance);
    this.formClient.controls['lieuNaissance'].setValue(this.client.lieuNaissance);
    this.formClient.controls['profession'].setValue(this.client.profession);
    this.formClient.controls['revenu'].setValue(this.client.revenu);
  }

  loadFormCreate(idBanquier: number){
    this.isEspaceAdmin = true;
    this.client = new Client()
    this.isFormUpdateMode = false;
    this.formClient.reset();
    this.idBanquier = idBanquier;
  }


  public updateClient(){
    this.client = <Client>this.formClient.value;
    this.client.idClient = this.idClient;
    this.clientHttpService.update$(this.formClient.value).subscribe(
      client => {
        this.client = client;
        this.formSaved.emit(this.client);
        alert("Les informations ont été modifié avec succès !");
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
