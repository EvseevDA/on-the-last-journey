import {NgModule} from '@angular/core';

import {OrderComponent} from './order.component';
import {OrderRoutingModule} from "./order-routing.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DatePipe, NgForOf, NgIf} from "@angular/common";
import {RouterLink} from "@angular/router";
import {SingletonOrderComponent} from './singleton-order/singleton-order.component';
import {ClientModule} from "../client/client.module";
import {OrderAdditionComponent} from './order-addition/order-addition.component';

@NgModule({
  imports: [
    OrderRoutingModule,
    FormsModule,
    NgForOf,
    RouterLink,
    DatePipe,
    ReactiveFormsModule,
    NgIf,
    ClientModule
  ],
  exports: [],
  declarations: [
    OrderComponent,
    SingletonOrderComponent,
    OrderAdditionComponent
  ],
  providers: [],
})
export class OrderModule {
}
