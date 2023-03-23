import { Component, OnInit, ViewChild } from '@angular/core';
import { Client } from 'src/app/model/client';
import { ClientHttpService } from 'src/app/service/http/client.http.service';
import { FormInfoClientComponent } from 'src/app/shared/form-info-client/form-info-client.component';

@Component({
  selector: 'app-consultation-infoperso',
  templateUrl: './consultation-infoperso.component.html',
  styleUrls: ['./consultation-infoperso.component.css']
})
export class ConsultationInfopersoComponent implements OnInit{

  @ViewChild(FormInfoClientComponent, {static : true}) formClient! : FormInfoClientComponent;

  idClient!: number
  client: Client = new Client();

  constructor(private clientHttpService: ClientHttpService) {}

  ngOnInit(): void {
    const id = localStorage.getItem('idUser');
    this.idClient = id !== null ? JSON.parse(id) : 0;
    this.loadData();
  }

  public loadData() {
    this.clientHttpService.retrieve$(this.idClient).subscribe(
      data => {
        this.client = data;
        this.formClient.loadFormUpdate(this.client, false);
      }
    );
  }


}
