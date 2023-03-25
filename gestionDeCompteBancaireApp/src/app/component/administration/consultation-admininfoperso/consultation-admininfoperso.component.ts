import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Banquier } from 'src/app/model/banquier';
import { Response } from 'src/app/model/response';
import { BanquierHttpService } from 'src/app/service/http/banquier.http.service';

@Component({
  selector: 'app-consultation-admininfoperso',
  templateUrl: './consultation-admininfoperso.component.html',
  styleUrls: ['./consultation-admininfoperso.component.css']
})
export class ConsultationAdmininfopersoComponent implements OnInit {

  banquier!: Banquier;

  idBanquier!: number;
  idAgence!: number;

  formBanquier!: FormGroup;



  constructor(private banquierHttpService: BanquierHttpService, private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    const id = localStorage.getItem('idUser');
    this.idBanquier = id !== null ? JSON.parse(id) : 0;
    this.formBanquier = this.formBuilder.group({
      numEmploye: [""],
      nom: [""],
      prenom: [""],
      email: ["", [Validators.required, Validators.email, Validators.maxLength(50)]],
      numTel: ["", [Validators.required, Validators.pattern("^[+][33]{1}[0-9]{10}$")]]
    });
    this.loadData();
  }

  public loadData() {
    this.banquierHttpService.retrieve$(this.idBanquier).subscribe(
      data => {
        this.banquier = data;
        console.log(this.banquier);
        this.idAgence = this.banquier.idAgence;
        this.formBanquier.controls['numEmploye'].setValue(this.banquier.numEmploye);
        this.formBanquier.controls['nom'].setValue(this.banquier.nom);
        this.formBanquier.controls['prenom'].setValue(this.banquier.prenom);
        this.formBanquier.controls['email'].setValue(this.banquier.email);
        this.formBanquier.controls['numTel'].setValue(this.banquier.numTel);
      }
    );
  }

  public updateBanquier(){
    this.banquier = this.formBanquier.value;
    this.banquier.id = this.idBanquier;
    this.banquier.idAgence = this.idAgence;
    console.log(this.banquier.id);
    this.banquierHttpService.update$(this.banquier).subscribe({
      next: data => {
        console.log(data);
        alert("Banquier updated");
        this.loadData();
      },
      error: errors => {
        console.log(errors);
      }
    });
  }

}
