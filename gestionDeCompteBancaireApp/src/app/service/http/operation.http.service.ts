import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Operation } from 'src/app/model/operation';
import { SnackbarService } from '../snackbar.service';

@Injectable({
providedIn: 'root'
})
export class OperationHttpService {
    private readonly baseUrl = 'http://localhost:8080/operation';
    constructor(private http:HttpClient,private snackbarService: SnackbarService ) {}

    operations$ = (idCompte : number) => <Observable<Array<Operation>>>this.http.get<Operation>(`${this.baseUrl}/list/${idCompte}`).pipe(
    tap(console.log),
    catchError(this.handleError)
    );

    
  handleError(error: HttpErrorResponse): Observable<never> {
    this.snackbarService.error(error.message);
    return throwError(() => `An error occured - Error code :'${error.status}`);
  } 
    
}