import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

import { LoginDto } from './login-dto';
import { User } from './user';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class AuthService {

  private _server = "http://localhost:8080/api";

  private _loginService = "/authentication/login";
  private _loginURL = this._server + this._loginService;

  private _logoutService = "/authentication/logout";
  private _logoutURL = this._server + this._logoutService;

  private _headers: Headers;

  constructor(
    private _http: Http
  ) { }

  login( loginDto:LoginDto):Promise<User> {

    this._headers = new Headers( {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Credentials' : 'true',
      'Access-Control-Allow-Methods': 'POST, GET, OPTIONS',
      'Access-Control-Max-Age': '3600',
      'Access-Control-Allow-Headers': 'Content-Type, Accept, X-Autorization, Access-Control-Allow-Credentials, Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age'
    } );

    return this._http
      .post(
          this._loginURL
        , JSON.stringify(loginDto)
        , {
          headers: this._headers
        })
      .toPromise()
      .then( response => {
        if (response) {
          console.log("Got a response");
          return response.json() as User;
        } else {
          console.log("Reponse is empty")
        }
      })
      .catch( this.handleError )
      ;
  }

  isAuthenticated(): boolean {
    let user = localStorage.getItem("currentUser");

    if ( user ) {
      return true;
    } else {
      return false;
    }
  }

  currentUser(): User {
    let strUser = localStorage.getItem("currentUser");
    let user = JSON.parse(strUser) as User;

    return user;
  }

  private handleError(error: any): Promise<any> {
    console.log(">>>>>>>>>>>>> Error: ", error.message || error);
    return Promise.reject(error.message || error);
  }

}
