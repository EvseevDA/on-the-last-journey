import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SystemComponent} from "./system/system.component";
import {RoleGuard} from "../role-guard/role-guard";

const routes: Routes = [
  {
    path: '',
    component: SystemComponent
  },
  {
    path: 'client',
    loadChildren: () => import('./client/client.module').then(m => m.ClientModule)
  },
  {
    path: 'order',
    loadChildren: () => import('./order/order.module').then(m => m.OrderModule)
  },
  {
    path: 'affilation-type',
    loadChildren: () => import('./affilation-type/affilation-type.module').then(m => m.AffilationTypeModule)
  },
  {
    path: 'provider',
    loadChildren: () => import('./provider/provider.module').then(m => m.ProviderModule)
  },
  {
    path: 'funeral-affilation',
    loadChildren: () => import('./funeral-affilation/funeral-affilation.module').then(m => m.FuneralAffilationModule)
  },
  {
    path: 'user',
    loadChildren: () => import('./user/user.module').then(m => m.UserModule),
    canActivate: [RoleGuard], data: { roles: ['ROLE_ADMIN'] }
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  declarations: [],
})
export class SystemRoutingModule {
}
