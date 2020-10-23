import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders  } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import * as AppUtils from '../common/app.utils';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class BookService {

  baseUrl:string = AppUtils.BACKEND_API_URL;

  constructor(private http: HttpClient) { }

  get(url) {
    return this.http.get(this.baseUrl+url).pipe(retry(1),catchError(this.handleError));
  }

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(error);
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
}
