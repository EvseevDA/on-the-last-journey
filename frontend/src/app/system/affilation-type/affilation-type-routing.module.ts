import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AffilationTypeComponent} from "./affilation-type.component";

const routes: Routes = [
  {
    path: '',
    component: AffilationTypeComponent,
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [],
  declarations: [],
})
export class AffilationTypeRoutingModule {
}
