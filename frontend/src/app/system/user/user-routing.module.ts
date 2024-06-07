import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserComponent} from "./user.component";
import {UserAdditionComponent} from "./user-addition/user-addition.component";

const routes: Routes = [
  {
    path: '',
    component: UserComponent
  },
  {
    path: 'new/addition',
    component: UserAdditionComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class UserRoutingModule {
}
