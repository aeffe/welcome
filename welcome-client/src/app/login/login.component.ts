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
  public showAlert:boolean = false;
  public alertMessage = "";

  constructor(
      private _authService: AuthService
  ) { }

  ngOnInit() {
  }

  login() {

    let retVal = this._authService
      .login(this.loginDto)
      .then( jsonUser => console.log(jsonUser) )
      .catch( this.handleLoginException );

    if ( retVal ) {
      this.showAlert = true;
      this.alertMessage = "Invalid username or password!";
    }

  }

  clear() {
    this.loginDto = new LoginDto("","");
    this.showAlert = false;
  }

  private handleLoginException(error: any): Promise<any> {
    console.log("************ Entering the handleLoginException");
    this.showAlert = true;
    this.alertMessage = "Invalid username or password!";
    return Promise.reject(error.message || error);
  }


}
