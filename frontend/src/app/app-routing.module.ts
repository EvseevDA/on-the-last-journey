import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ErrorComponent} from "./error/error/error.component";
import {HomePageComponent} from "./home-page/home-page/home-page.component";

const routes: Routes = [
  {
    path: '',
    component: HomePageComponent
  },
  {
    path: 'system',
    loadChildren: () => import('./system/system.module').then(m => m.SystemModule)
  },
  {
    path: '**',
    component: ErrorComponent
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: [],
})
export class AppRoutingModule {
}
