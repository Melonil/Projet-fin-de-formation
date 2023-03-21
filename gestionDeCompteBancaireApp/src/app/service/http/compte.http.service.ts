import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Compte } from '../../model/compte';
import { SnackbarService } from '../snackbar.service';

@Injectable({
  providedIn: 'root'
})
export class CompteHttpService {

  private readonly baseUrl = 'http://localhost:8080/compte';
  constructor(private http:HttpClient,private snackbarService: SnackbarService ) {}

  comptes$ = <Observable<Response>>this.http.get<Compte>(`${this.baseUrl}/list`).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  retrieve$ = (compteId : number) => <Observable<Compte>>
  this.http.get<Compte>(`${this.baseUrl}/get/${compteId}`).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  getMainAccount$ = (idClient : number) => <Observable<Compte>>
  this.http.get<Compte>(`${this.baseUrl}/getMainAccount/${idClient}`).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  save$ = (compte : Compte) => <Observable<Compte>>
  this.http.post<Compte>(`${this.baseUrl}/save`,compte).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  update$ = (compteId:number, compte : Compte) => <Observable<Compte>>
  this.http.put<Compte>(`${this.baseUrl}/save/${compteId}`,compte).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  delete$ = (compteId : number) => <Observable<Compte>>
  this.http.delete<Compte>(`${this.baseUrl}/delete/${compteId}`).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  withdraw$ = (compteId : number, montant : number) => <Observable<Compte>>
  this.http.put<Compte>(`${this.baseUrl}/withdraw`,{"idCompte":compteId,"montant":montant}).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  deposit$ = (compteId : number, montant : number) => <Observable<Compte>>
  this.http.put<Compte>(`${this.baseUrl}/deposit`,{"idCompte":compteId,"montant":montant}).pipe(
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
