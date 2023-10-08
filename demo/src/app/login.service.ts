import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, throwError } from 'rxjs';
import { Guest } from './Models/guest';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor(private  _http : HttpClient){

  }
  
  public LoginUserFromRemote(guest: Guest): Observable<string> {

    return this._http.post('http://localhost:8081/guests/login', guest, {

      observe: 'response',

      responseType: 'text'

    }).pipe(

      map((response: HttpResponse<any>) => {

        const token = response.headers.get('Authorization');

        return token || '';

      }),

      catchError((error: any) => throwError('Authentication failed: ' + error))

    );




  }
}
