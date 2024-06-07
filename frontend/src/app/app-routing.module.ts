import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ErrorComponent} from "./error/error/error.component";
import {HomePageComponent} from "./home-page/home-page/home-page.component";
import {RoleGuard} from "./role-guard/role-guard";

const routes: Routes = [
  {
    path: '',
    component: HomePageComponent
  },
  {
    path: 'system',
    loadChildren: () => import('./system/system.module').then(m => m.SystemModule),
    canActivate: [RoleGuard], data: { roles: ['ROLE_USER', 'ROLE_ADMIN'] }
  },
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
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
