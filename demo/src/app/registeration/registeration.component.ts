import { Component,OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { RegisterationserviceService } from '../registerationservice.service';
import { Guest } from '../Models/guest';


@Component({
  selector: 'app-registeration',
  templateUrl: './registeration.component.html',
  styleUrls: ['./registeration.component.css']
})
export class RegisterationComponent implements OnInit{
 
  guest = new Guest();
  msg = '';
  confirmPassword = '';
  passwordMismatch = false;
   constructor(private _service:RegisterationserviceService, private _router:Router){

   }

  registerUser() {
    if (this.guest.guestpassword !== this.confirmPassword) {

      this.passwordMismatch = true;

      return;

    }
    this._service.RegisterUserFromRemote(this.guest).subscribe(
      (      data: any)=>{
        console.log('Registration submitted');
        this.msg='Registration Successful';
        this._router.navigate(['home']);
      },
      (      error: { error: string; })=>{
        console.log("Exception Occured");
        this.msg=error.error;
      }
      )}

  ngOnInit(): void {
      
  }

}

