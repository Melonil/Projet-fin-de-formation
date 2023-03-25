import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, Observable, tap, throwError } from "rxjs";
import { Banquier } from "src/app/model/banquier";
import { Response } from "src/app/model/response";

@Injectable({
    providedIn: 'root'
})
export class BanquierHttpService{

    private readonly baseUrl = 'http://localhost:8080/banquier';

    constructor(private http:HttpClient) {}

    $retrieveAll = () => <Observable<Banquier>>
    this.http.get(`${this.baseUrl}/list`).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    retrieve$ = (banquierId: number) => <Observable<Banquier>>
    this.http.get(`${this.baseUrl}/get/${banquierId}`).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    create$ = (banquier: Banquier) => <Observable<Banquier>>
    this.http.post(`${this.baseUrl}/save`, banquier).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    update$ = (banquier: Banquier) => <Observable<Banquier>>
    this.http.put(`${this.baseUrl}/save`, banquier).pipe(
        tap(console.log),
        catchError(this.handleError)
    );

    archive$ = (banquierId: number) => <Observable<Banquier>>
    this.http.delete(`${this.baseUrl}/archive/${banquierId}`).pipe(
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