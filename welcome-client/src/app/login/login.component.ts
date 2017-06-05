import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
// import { Router } from '@angular/router';

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
    , AuthService
//    , Router
  ]
})
export class LoginComponent implements OnInit {

  public loginDto:LoginDto = new LoginDto("","");
  public showAlert:boolean = false;
  public alertMessage = "";
  public currentUser:User = null;

  constructor(
        private _authService: AuthService
      // , private _router: Router
  ) { }

  ngOnInit() {
  }

  login() {

    let retVal = this._authService
      .login(this.loginDto)
      .then( jsonUser => this.currentUser = jsonUser as User )
      .catch( this.handleLoginException );

    if ( retVal && !this.currentUser ) {
      this.showAlert = true;
      this.alertMessage = "Invalid username or password!";
    } else {
      console.log("Logged in!")
      // this._router.navigate(['home']);
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
