import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {FuneralAffilationComponent} from "./funeral-affilation.component";
import {SingletonAffilationComponent} from "./singleton-affilation/singleton-affilation.component";
import {AffilationAdditionComponent} from "./affilation-addition/affilation-addition.component";

const routes: Routes = [
  {
    path: '',
    component: FuneralAffilationComponent
  },
  {
    path: ':id',
    component: SingletonAffilationComponent
  },
  {
    path: 'new/addition',
    component: AffilationAdditionComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class FuneralAffilationRoutingModule {
}
