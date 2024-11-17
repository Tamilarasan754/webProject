import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { LoginpageComponent } from './loginpage/loginpage.component';

const routes: Routes = [
  {
    path:'app-loginpage',component: LoginpageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
