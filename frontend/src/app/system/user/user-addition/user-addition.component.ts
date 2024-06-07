import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import {UserService} from "../../service/user.service";
import {UserDto} from "../../model/user-dto";

@Component({
  selector: 'app-user-addition',
  templateUrl: './user-addition.component.html',
  styleUrls: ['./user-addition.component.css', '../../system.component.css']
})

export class UserAdditionComponent {

  constructor(private userService: UserService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  confirmPassword(): ValidatorFn {
    return (
      control: AbstractControl
    ): ValidationErrors | null => {
      return control.value.password == control.value.confirmPassword ? null : { PasswordMismatch: true }
    }
  }

  public form = new FormGroup({
    login: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(16)
    ]),
    confirmPassword: new FormControl('', [
      Validators.required
    ]),
    roles: new FormControl('', [
      Validators.required,
      Validators.minLength(6)
    ]),
  },
    { validators: this.confirmPassword() }
  );

  public submit(): void {
    if (this.form.valid) {
      let userDto: UserDto = {
        login: this.form.value.login as string,
        password: this.form.value.password as string,
        roles: this.form.value.roles as string,
      }
      this.userService.addUser(userDto)
        .subscribe(_ => {
          alert("Пользователь добавлен. Вы будете перенапрвлены на страницу с пользователями");
          this.router.navigate(['../../'], { relativeTo: this.route });
        })
    }
  }

}
