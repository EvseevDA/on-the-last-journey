import {NgModule} from '@angular/core';

import {SystemComponent} from './system/system.component';
import {SystemRoutingModule} from "./system-routing.module";
import {RouterLink, RouterOutlet} from "@angular/router";
import {ClientService} from "./service/client.service";
import {NgForOf, NgIf} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {OrderService} from "./service/order.service";
import {UserService} from "./service/user.service";

@NgModule({
  imports: [
    SystemRoutingModule,
    RouterLink,
    NgForOf,
    HttpClientModule,
    FormsModule,
    RouterOutlet,
    NgIf
  ],
  exports: [],
  declarations: [
    SystemComponent,
  ],
  providers: [ClientService, OrderService, UserService],
})
export class SystemModule {
}
