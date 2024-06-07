import {Component} from '@angular/core';
import {UserService} from "../../system/service/user.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', '../../system/system.component.css']
})
export class LoginComponent {

  constructor(private userService: UserService,
              private router: Router) {
  }

  form = new FormGroup({
    login: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(16)
    ])
  })

  public submit(): void {
    this.userService.userExistsByLoginAndPassword(this.form.value.login as string, this.form.value.password as string)
      .subscribe(e => {
        if (!e) {
          alert('Неверный логин или пароль');
        } else {
          this.userService.getUserByLoginAndPassword(this.form.value.login as string, this.form.value.password as string)
            .subscribe(u => {
              if (u) {
                window.sessionStorage.setItem('user', JSON.stringify(u));
                this.router.navigate(['/system']);
              }
            })
        }
      })
  }

  public goHome(): void {
    this.router.navigate(['/'])
  }

}
