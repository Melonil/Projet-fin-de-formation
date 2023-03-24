import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationHttpService } from 'src/app/service/http/authentification.http.service';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { Identifiant } from 'src/app/model/identifiant';

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.css']
})
export class ConnectionComponent implements OnInit{
  formConnection!:FormGroup;
  login!:string;
  password!:string;
  constructor(private router: Router,private service : AuthentificationHttpService,private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.formConnection = this.formBuilder.group({
      login : [null,[Validators.required]],
      password : [null,[Validators.required]]
    })
  }
  connect(){
    this.login = this.formConnection.get('login')?.value;
    this.password = this.formConnection.get('password')?.value;
    this.service.authenticate$({"login":this.login,"password":this.password}).subscribe(
      (user) => {
        sessionStorage.setItem('idUser', user.id.toString());
        if(user.role=="BANQUIER"){
          this.router.navigateByUrl('/espaceadministration');
        }else{
          this.router.navigateByUrl('/espaceclient');
        }
      }
    );
  }
}
