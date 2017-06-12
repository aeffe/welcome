import { Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PublicHomeComponent } from './public-home/public-home.component';

import { IsLoggedIn } from './login/is-logged-in';

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/public-home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [ IsLoggedIn ]
  },
  {
    path: 'public-home',
    component: PublicHomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'logout',
    component: LoginComponent
  }
];
