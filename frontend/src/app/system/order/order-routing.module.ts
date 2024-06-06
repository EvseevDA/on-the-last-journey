import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {OrderComponent} from "./order.component";
import {SingletonOrderComponent} from "./singleton-order/singleton-order.component";
import {OrderAdditionComponent} from "./order-addition/order-addition.component";

const routes: Routes = [
  {
    path: '',
    component: OrderComponent
  },
  {
    path: ':id',
    component: SingletonOrderComponent
  },
  {
    path: 'new/addition',
    component: OrderAdditionComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class OrderRoutingModule {
}
