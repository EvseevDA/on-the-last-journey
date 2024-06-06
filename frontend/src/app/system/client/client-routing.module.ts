import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ClientComponent} from "./client.component";
import {SingletonClientComponent} from "./singleton-client/singleton-client.component";
import {ClientAdditionComponent} from "./client-addition/client-addition.component";

const routes: Routes = [
  {
    path: '',
    component: ClientComponent,
  },
  {
    path: ':id',
    component: SingletonClientComponent
  },
  {
    path: 'new/addition',
    component: ClientAdditionComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class ClientRoutingModule {
}
