import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {OrderComponent} from "./order.component";
import {SingletonOrderComponent} from "./singleton-order/singleton-order.component";
import {OrderAdditionComponent} from "./order-addition/order-addition.component";
import {RoleGuard} from "../../role-guard/role-guard";

const routes: Routes = [
  {
    path: '',
    component: OrderComponent,
  },
  {
    path: ':id',
    component: SingletonOrderComponent,
    canActivate: [RoleGuard], data: { roles: ['ROLE_ADMIN'] }
  },
  {
    path: 'new/addition',
    component: OrderAdditionComponent,
    canActivate: [RoleGuard], data: { roles: ['ROLE_ADMIN'] }
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class OrderRoutingModule {
}
