import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

import { AuthService } from './auth.service';

@Injectable()
export class IsLoggedIn implements CanActivate {

  constructor(
    private _authService: AuthService,
    private _router: Router
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ) {
    console.log( "Checking login status:" );
    console.log( "Logged IN --> " + this._authService.isAuthenticated() );
    this._router.navigate(["login"]);
    return this._authService.isAuthenticated();
  }
}
