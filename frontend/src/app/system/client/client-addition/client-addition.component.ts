import { Component } from '@angular/core';
import {ClientService} from "../../service/client.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ClientDto} from "../../model/client-dto";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-client-addition',
  templateUrl: './client-addition.component.html',
  styleUrls: ['./client-addition.component.css', '../../system.component.css']
})
export class ClientAdditionComponent {

  constructor(private clientService: ClientService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  public form = new FormGroup({
    surname: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    name: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    patronymic: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    country: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    region: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    city: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    phoneNumber: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    index: new FormControl(0, [
      Validators.required
    ])
  })

  public submit(): void {
    if (this.form.valid) {
      let clientDto: ClientDto = {
        surname: this.form.value.surname as string,
        name: this.form.value.name as string,
        patronymic: this.form.value.patronymic as string,
        country: this.form.value.country as string,
        region: this.form.value.region as string,
        city: this.form.value.city as string,
        phoneNumber: this.form.value.phoneNumber as string,
        index: this.form.value.index as number
      }
      this.clientService.addClient(clientDto)
        .subscribe(c => {
          alert("Клиент добавлен. Вы будете перенапрвлены на страницу с клиентами");
          this.router.navigate(['../../'], { relativeTo: this.route });
        })
    }
  }
}
