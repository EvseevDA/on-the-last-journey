import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service";
import {User} from "../model/user";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css', '../system.component.css']
})
export class UserComponent implements OnInit {

  constructor(private userService: UserService,) {
  }

  public users: User[] = [];

  public selectedUserId: number = 0;

  public deleteById(id: number): void {
    let deletionConfirmed: boolean = confirm(`Вы действительно хотите удалить пользователя с id ${id}?`);
    if (deletionConfirmed) {
      this.userService.deleteUser(id).subscribe(_ => {
        console.log(id);
        alert('Пользователь удален.');
        this.users = []
        this.userService.getAllUsers()
          .subscribe(us => {
            us.forEach(u => this.users.push(u));
            this.selectedUserId = this.users[0].id;
          });
      });
    }
  }

  ngOnInit(): void {
    this.userService.getAllUsers()
      .subscribe(us => {
        us.forEach(u => this.users.push(u));
        this.selectedUserId = this.users[0].id;
      });
  }

}
