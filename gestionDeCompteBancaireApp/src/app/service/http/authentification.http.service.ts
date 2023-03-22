import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Identifiant } from 'src/app/model/identifiant';
import { Client } from '../../model/client';
import { SnackbarService } from '../snackbar.service';

@Injectable({
  providedIn: 'root'
})
export class CompteHttpService {

  private readonly baseUrl = 'http://localhost:8080/authenticate';
  constructor(private http:HttpClient,private snackbarService: SnackbarService ) {}

  authenticate$ = (identifiant : Identifiant) => <Observable<Client>>
  this.http.post<Identifiant>(`${this.baseUrl}/authenticate`,identifiant).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  handleError(error: HttpErrorResponse): Observable<never> {
    //this.snackbarService.error(error.message);
    alert(error.error.message);
    console.log(error);
    return throwError(() => `An error occured - Error code :'${error.status}`);
  } 

}