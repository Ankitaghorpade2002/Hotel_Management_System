
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn:"root"
})

export class Room {
    constructor(private  _http : HttpClient){

    }
    // public RegisterUserFromRemote(user:User):Observable<any>{
    //     return this._http.post<any>("http://localhost:8081/guest/add",user)
    // }
    handleError(error:Response){

    }
}
