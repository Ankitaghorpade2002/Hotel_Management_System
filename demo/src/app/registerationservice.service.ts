import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Guest } from './Models/guest';


@Injectable({
  providedIn: 'root'
})
export class RegisterationserviceService {


  constructor(private  _http : HttpClient){

  }
  public RegisterUserFromRemote(guest:Guest):Observable<any>{
      return this._http.post<any>("http://localhost:8081/guests/addUser",guest)
  }
  handleError(error:Response){

  }
}
