import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PublicHomeComponent } from './public-home/public-home.component';

import { IsLoggedIn } from './login/is-logged-in';
import { AuthService } from './login/auth.service';

import { routes } from './app.routes';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    PublicHomeComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot( routes )
  ],
  providers: [
    IsLoggedIn,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
