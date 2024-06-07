import {NgModule} from '@angular/core';

import {AuthComponent} from './auth.component';
import {LoginComponent} from './login/login.component';
import {AuthRoutingModule} from "./auth-routing.module";
import {RouterLink} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";
import {UserService} from "../system/service/user.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  imports: [AuthRoutingModule, RouterLink, ReactiveFormsModule, HttpClientModule],
  exports: [],
  declarations: [AuthComponent, LoginComponent],
  providers: [UserService],
})
export class AuthModule {
}
