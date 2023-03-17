import { Component, OnInit } from '@angular/core';
import { catchError, map, Observable, of, startWith } from 'rxjs';
import { AppState } from './entity/appState';
import { DataState } from './enum/dataState.enum';
import { CompteService } from './service/compte.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  appState$! : Observable<AppState<Response>>;
  constructor(private compteService : CompteService) {}

    ngOnInit(): void {
      this.appState$ = this.compteService.comptes$.pipe(
        map(response => {
          return {
            dataState : DataState.LOADED_STATE,
            appData : response
          }
        }),
        startWith({dataState : DataState.LOADING_STATE}),
        catchError((error:string) => {
          return of({dataState : DataState.ERROR_STATE, errorMessage : error}) 
        })
      );
    }   

}
