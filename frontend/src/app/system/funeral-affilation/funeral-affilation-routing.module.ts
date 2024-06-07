import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FuneralAffilationComponent} from "./funeral-affilation.component";
import {SingletonAffilationComponent} from "./singleton-affilation/singleton-affilation.component";
import {AffilationAdditionComponent} from "./affilation-addition/affilation-addition.component";
import {RoleGuard} from "../../role-guard/role-guard";

const routes: Routes = [
  {
    path: '',
    component: FuneralAffilationComponent,
  },
  {
    path: ':id',
    component: SingletonAffilationComponent,
    canActivate: [RoleGuard], data: { roles: ['ROLE_ADMIN'] }
  },
  {
    path: 'new/addition',
    component: AffilationAdditionComponent,
    canActivate: [RoleGuard], data: { roles: ['ROLE_ADMIN'] }
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class FuneralAffilationRoutingModule {
}
