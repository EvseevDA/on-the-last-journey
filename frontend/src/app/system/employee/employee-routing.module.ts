import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {EmployeeComponent} from "./employee.component";
import {RoleGuard} from "../../role-guard/role-guard";

const routes: Routes = [
  {
    path: '',
    component: EmployeeComponent,
    canActivate: [RoleGuard], data: { roles: ['ROLE_ADMIN'] }
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class EmployeeRoutingModule {
}
