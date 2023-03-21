import { Component, Input, OnInit } from '@angular/core';
import { catchError, Observable, of, startWith } from 'rxjs';
import { AppState } from 'src/app/model/appState';
import { DataState } from 'src/app/model/enum/dataState.enum';
import { Compte } from 'src/app/model/compte';
import { CompteHttpService } from 'src/app/service/http/compte.http.service';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { Operation } from 'src/app/model/operation';
import { OperationHttpService } from 'src/app/service/http/operation.http.service';

@Component({
  selector: 'consultation-compte',
  templateUrl: './consultation-compte.component.html',
  styleUrls: ['./consultation-compte.component.css']
})
export class ConsultationCompteComponent implements OnInit {
  compte? : Compte;
  operations! :Array<Operation>;
  dateDuJour: Date = new Date();
  montantRetrait? :number;
  formRetrait!:FormGroup;
  formDepot!:FormGroup;
  idClient = 1;

  constructor(
    private compteHttpService : CompteHttpService,
    private operationHttpService : OperationHttpService,
    private formBuilder:FormBuilder
  ) {}
 
    ngOnInit(): void {
      this.loadCompte();
      this.formRetrait = this.formBuilder.group({
        montantRetrait : [0,[Validators.required,Validators.min(0)]]
      })
      this.formDepot = this.formBuilder.group({
        montantDepot : [0,[Validators.required,Validators.min(0)]]
      })
    }

    public loadCompte(){
      this.compteHttpService.getMainAccount$(this.idClient).subscribe(
        (compte) => {
          this.compte = compte;
          this.loadOperations(compte.id);
        }
      );

    }

    public loadOperations(idCompte : number){
      this.operationHttpService.operations$(idCompte).subscribe(
        (data) => {
          this.operations = data;
        }
      );
    }

    public formatDate(date : Date) : string {
      date = new Date(date);
      return date.toLocaleDateString();
    }

    public retrait(){
      this.compteHttpService.withdraw$(this.compte!.id,this.formRetrait.value.montantRetrait).subscribe(
        (compte) => {
          this.compte = compte;
        }
      );
      let element: HTMLElement = document.getElementById("closeModalRetrait") as HTMLElement;
      element.click();
    }

    public depot(){
      this.compteHttpService.deposit$(this.compte!.id,this.formDepot.value.montantDepot).subscribe(
        (compte) => {
          this.compte = compte;
        }
      );
      let element: HTMLElement = document.getElementById("closeModalDepot") as HTMLElement;
      element.click();
    }

}
