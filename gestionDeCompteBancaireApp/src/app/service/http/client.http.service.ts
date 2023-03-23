import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, Observable, tap, throwError } from "rxjs";
import { Client } from "src/app/model/client";

@Injectable({
    providedIn: 'root'
})
export class ClientHttpService{

    private readonly baseUrl = 'http://localhost:8080/client';

    constructor(private http:HttpClient) {}

    $retrieveAll = () => <Observable<Client>>
    this.http.get(`${this.baseUrl}/list`).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    retrieveByIdBanquier$ = (banquierId: number) => <Observable<Array<Client>>>
    this.http.get(`${this.baseUrl}/banquier/${banquierId}`).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    retrieve$ = (clientId: number) => <Observable<Client>>
    this.http.get(`${this.baseUrl}/get/${clientId}`).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    create$ = (client: Client) => <Observable<Client>>
    this.http.post(`${this.baseUrl}/save`, client).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    update$ = (client: Client) => <Observable<Client>>
    this.http.put(`${this.baseUrl}/save`, client).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    archive$ = (clientId: number) => <Observable<Client>>
    this.http.delete(`${this.baseUrl}/archive/${clientId}`).pipe(
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