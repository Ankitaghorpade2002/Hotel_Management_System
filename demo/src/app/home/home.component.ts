import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from '../booking.service';
import { Guest } from '../Models/guest';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  guest = new Guest();
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  constructor(private _service:BookingService, private _router:Router){

  }
BookingUser(){
  this._service.BookingUserFromRemote(this.guest).subscribe(
    // (      response: any)=>{
    //   const token = response.token;
    //   localStorage.setItem('token', token);
    //   this.loginSuccess = true;
    //   console.log('Login Successful');
    //   this._router.navigate(['rooms']);
    // },
    // (      error: { error: string; })=>{
    //   console.log("Exception Occured");
    //   this.loginSuccess = false;
    //   this.msg = 'Bad credentials, please enter valid email and password';
    // }
    )}
}
  

