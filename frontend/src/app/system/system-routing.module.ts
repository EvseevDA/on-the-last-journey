import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ClientComponent} from "./client/client.component";
import {SystemComponent} from "./system/system.component";
import {SingletonClientComponent} from "./client/singleton-client/singleton-client.component";

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
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  declarations: [],
})
export class SystemRoutingModule {
}
