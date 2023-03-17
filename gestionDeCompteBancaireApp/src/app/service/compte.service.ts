import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Compte } from '../entity/compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  private readonly baseUrl = 'http://localhost:8080/compte';
  constructor(private http:HttpClient ) {}

  comptes$ = <Observable<Response>>this.http.get<Response>(`${this.baseUrl}/list`).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  retrieve$ = (compteId : number) => <Observable<Response>>
  this.http.get<Response>(`${this.baseUrl}/get/${compteId}`).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  save$ = (compte : Compte) => <Observable<Response>>
  this.http.post<Response>(`${this.baseUrl}/save`,compte).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  update$ = (compteId:number, compte : Compte) => <Observable<Response>>
  this.http.put<Response>(`${this.baseUrl}/save/${compteId}`,compte).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  delete$ = (compteId : number) => <Observable<Response>>
  this.http.delete<Response>(`${this.baseUrl}/delete/${compteId}`).pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(() => `An error occured - Error code :'${error.status}`);
  } 
}
