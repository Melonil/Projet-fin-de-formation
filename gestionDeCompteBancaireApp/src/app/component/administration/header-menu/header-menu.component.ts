import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-header-menu',
  templateUrl: './header-menu.component.html',
  styleUrls: ['./header-menu.component.css']
})



export class HeaderMenuComponent {

  constructor(private router: Router) { }

  public deconnect(){
    sessionStorage.setItem('idUser', "");
    this.router.navigateByUrl('/logout');
  }
}
