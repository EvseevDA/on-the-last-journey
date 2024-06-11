import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {User} from "../system/model/user";
import {Util} from "../../util/util";

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor() { }

  private util: Util = new Util();

  canActivate(
    route: ActivatedRouteSnapshot,
    _: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let currentUser: string | null = window.sessionStorage.getItem('user');

    if (currentUser) {
      let currentUserAsJson: User = JSON.parse(currentUser) as User;
      let roles: string[] = currentUserAsJson.roles.split(',');
      let allowedRoles: string[] = route.data['roles'] as string[];

      if (this.util.crosses(roles, allowedRoles)) {
        return true;
      }
    }

    alert('У вас нет доступа к этой странице');
    return false;
  }

}
