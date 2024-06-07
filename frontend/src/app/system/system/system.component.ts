import {Component} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-system',
  templateUrl: './system.component.html',
  styleUrls: ['./system.component.css']
})
export class SystemComponent {

  constructor(private router: Router) {
  }

  public logout(): void {
    window.sessionStorage.clear();
    this.router.navigate(['/']);
  }

  protected readonly window = window;
}
