import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ClientComponent} from "./client.component";
import {SingletonClientComponent} from "./singleton-client/singleton-client.component";
import {ClientAdditionComponent} from "./client-addition/client-addition.component";
import {RoleGuard} from "../../role-guard/role-guard";

const routes: Routes = [
  {
    path: '',
    component: ClientComponent,
  },
  {
    path: ':id',
    component: SingletonClientComponent,
    canActivate: [RoleGuard], data: { roles: ['ROLE_ADMIN'] }
  },
  {
    path: 'new/addition',
    component: ClientAdditionComponent,
    canActivate: [RoleGuard], data: { roles: ['ROLE_ADMIN'] }
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class ClientRoutingModule {
}
