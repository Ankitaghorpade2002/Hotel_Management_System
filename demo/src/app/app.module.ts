import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RegisterationComponent } from './registeration/registeration.component';
import { HomeComponent } from './home/home.component';
import { Routes,RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RoomsComponent } from './rooms/rooms.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BookingComponent } from './booking/booking.component';

const appRoutes:Routes=[
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'register', component:RegisterationComponent},
  {path:'home', component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path:'rooms', component:RoomsComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    RegisterationComponent,
    HomeComponent,
    LoginComponent,
    RoomsComponent,
    BookingComponent,
    
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
