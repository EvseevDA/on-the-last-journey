import {NgModule} from '@angular/core';

import {UserComponent} from './user.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule, NgForOf} from "@angular/common";
import {RouterLink, RouterModule} from "@angular/router";
import {UserRoutingModule} from "./user-routing.module";
import {UserAdditionComponent} from './user-addition/user-addition.component';

@NgModule({
  imports: [
    UserRoutingModule,
    RouterModule,
    FormsModule,
    NgForOf,
    RouterLink,
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [],
  declarations: [UserComponent, UserAdditionComponent],
  providers: [],
})
export class UserModule {
}
