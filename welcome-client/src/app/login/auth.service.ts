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
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Credentials' : 'true',
      'Access-Control-Allow-Methods': 'POST, GET, OPTIONS',
      'Access-Control-Max-Age': '3600',
      'Access-Control-Allow-Headers': 'Content-Type, Accept, X-Autorization'
    });


    return this._http
      .post(
          this._loginURL
        , JSON.stringify(loginDto)
        , this._headers)
      .toPromise()
      .then( response => {
        if (response) {
          console.log("Got a response");
          return response.json() as User;
        } else {
          console.log("Reponse is empty")
        }
      })
      .catch( this.handleError );
  }

  private handleError(error: any): Promise<any> {
    console.log("**** RUNNING HANDLE ERROR ****");
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
