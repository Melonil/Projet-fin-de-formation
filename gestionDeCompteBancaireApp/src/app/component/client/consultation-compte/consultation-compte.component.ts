import { Component, Input, OnInit,ViewChild } from '@angular/core';
import { catchError, Observable, of, startWith } from 'rxjs';
import { AppState } from 'src/app/model/appState';
import { DataState } from 'src/app/model/enum/dataState.enum';
import { Compte } from 'src/app/model/compte';
import { CompteHttpService } from 'src/app/service/http/compte.http.service';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { Operation } from 'src/app/model/operation';
import { OperationHttpService } from 'src/app/service/http/operation.http.service';
import { TableOperationClientComponent } from 'src/app/shared/table-operation-client/table-operation-client.component';

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
  idClient! : number;
  errorSoldeInsuffisant : boolean = false;
  @ViewChild(TableOperationClientComponent, {static : true}) tableOperationComponent! : TableOperationClientComponent;

  constructor(
    private compteHttpService : CompteHttpService,
    private formBuilder:FormBuilder
  ) {}
 
    ngOnInit(): void {
      const id = sessionStorage.getItem('idUser');
      this.idClient = id !== null ? JSON.parse(id) : 0;
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
          this.tableOperationComponent.loadOperations(compte.id);
        }
      );

    }



    public formatDate(date : Date) : string {
      date = new Date(date);
      return date.toLocaleDateString();
    }

    public retrait(){
      this.compteHttpService.withdraw$(this.compte!.id,this.formRetrait.value.montantRetrait).subscribe(
        compte => {
          this.compte = compte;
          this.tableOperationComponent.loadOperations(compte.id);

          this.errorSoldeInsuffisant = false;
          let element: HTMLElement = document.getElementById("closeModalRetrait") as HTMLElement;
          element.click();
        },
        error => {
          this.errorSoldeInsuffisant = true;
        }
      );
    }

    public depot(){
      this.compteHttpService.deposit$(this.compte!.id,this.formDepot.value.montantDepot).subscribe(
        (compte) => {
          this.compte = compte;
          this.tableOperationComponent.loadOperations(compte.id);
        }
      );
      let element: HTMLElement = document.getElementById("closeModalDepot") as HTMLElement;
      element.click();
    }

}
