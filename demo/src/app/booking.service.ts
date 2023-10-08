import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Guest } from './Models/guest';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private  _http : HttpClient){

  }
  public BookingUserFromRemote(guest:Guest):Observable<any>{
      return this._http.post<any>("http://localhost:8083/booking/add",guest)
  }
  handleError(error:Response){

  }
}
