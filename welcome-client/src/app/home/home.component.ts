import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../login/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public currentUser:User;

  constructor(
      private _router: Router
  ) {
    let user = localStorage.getItem("currentUser");

    console.log('****************************** ', user);

    if (user == null) {
      console.log("************ Current user not set");
      this._router.navigate(['/login']);
    }
 }

  ngOnInit() {
  }

}
