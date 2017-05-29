import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

import { AuthService } from './auth.service';
import { LoginDto } from './login-dto';
import { User } from './user';

@Component({
    selector: 'app-login'
  , templateUrl: './login.component.html'
  , styleUrls: [
    './login.component.css'
  ]
  , providers: [
    AuthService
  ]
})
export class LoginComponent implements OnInit {

  public loginDto:LoginDto = new LoginDto("","");

  constructor(
      private _authService: AuthService
  ) { }

  ngOnInit() {
  }

  login() {

    this._authService
      .login(this.loginDto)
      .then( jsonUser => console.log(jsonUser) );

  }

  clear() {
    this.loginDto = new LoginDto("","");
  }

}
