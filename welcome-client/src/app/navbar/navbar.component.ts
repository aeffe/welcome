import { Component, OnInit } from '@angular/core';
import { routes } from '../app.routes';
import { AuthService } from '../login/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public navRoutes = routes;
  public title = "welcome";
  public loggedIn = this._authService.currentUser() != null;
  public currentUser = this._authService.currentUser();

  constructor(
    private _authService: AuthService
  ) { }

  ngOnInit() {
  }

}
