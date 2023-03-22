import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Identifiant } from 'src/app/model/identifiant';
import { UserAccount } from 'src/app/model/userAccount';
import { Client } from '../../model/client';
import { SnackbarService } from '../snackbar.service';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationHttpService {

  private readonly baseUrl = 'http://localhost:8080/user';
  constructor(private http:HttpClient,private snackbarService: SnackbarService ) {}

  authenticate$ = (identifiant : Identifiant) => <Observable<UserAccount>>
  this.http.post<Identifiant>(`${this.baseUrl}/authenticate`,identifiant).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  handleError(error: HttpErrorResponse): Observable<never> {
    //this.snackbarService.error(error.message);
    alert(error.error.message);
    return throwError(() => `An error occured - Error code :'${error.status}`);
  } 

}