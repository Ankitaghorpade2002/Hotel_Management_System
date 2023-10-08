import { Component, OnInit } from '@angular/core';
import { Guest } from '../Models/guest';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginSuccess= false;
  ngOnInit(): void {
    
  }

  guest = new Guest();
  msg = '';
  constructor(private _service:LoginService, private _router:Router,private _http:HttpClient){

  }

   LoginUser() {
    // if (this.guest.guestpassword !== this.confirmPassword) {

    //   this.passwordMismatch = true;

    //   return;

    //}
    this._service.LoginUserFromRemote(this.guest).subscribe(
      (      response: any)=>{
        const token = response.token;
        localStorage.setItem('token', token);
        this.loginSuccess = true;
        console.log('Login Successful');
        this._router.navigate(['rooms']);
      },
      (      error: { error: string; })=>{
        console.log("Exception Occured");
        this.loginSuccess = false;
        this.msg = 'Bad credentials, please enter valid email and password';
      }
      )}
    

}
