import { Component, OnInit } from '@angular/core';
import { LoginDto } from './login-dto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginDto: LoginDto = {"username":"", "password":""};
  
  constructor() { }

  ngOnInit() {
  }
  
  login() {
      console.log("Trying to login " + this.loginDto.username);
  }
  
  clear() {
      this.loginDto.password = "";
      this.loginDto.username= "";
  }

}
