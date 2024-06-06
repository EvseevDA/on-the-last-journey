import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ClientService} from "../../service/client.service";
import {Client} from "../../model/client";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-singleton-client',
  templateUrl: './singleton-client.component.html',
  styleUrls: ['./singleton-client.component.css', '../../system.component.css']
})
export class SingletonClientComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private clientService: ClientService,
              private router: Router) {
  }

  public instance!: Client;

  public editingMode: boolean = false;

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.clientService.getClientById(params['id']).subscribe(c => this.instance = c);
    })
  }

  public edit(): void {
    this.editingMode = true;
    this.form.patchValue(this.instance);
  }

  public cancelEditing(): void {
    this.editingMode = false;
  }

  public deleteById(id: number): void {
    let deletionConfirmed: boolean = confirm(`Вы действительно хотите удалить пользователя с id ${id}?`);
    if (deletionConfirmed) {
      this.clientService.deleteClient(id).subscribe(_ => {
        console.log(id);
        alert('Клиент удален, вы будете перенапрвлены на страницу с клиентами');
        this.router.navigate(['../'], { relativeTo: this.route });
      });
    }
  }

  public submit(): void {
    if (this.form.valid) {
      let client: Client = {
        id: this.instance.id,
        surname: this.form.value.surname as string,
        name: this.form.value.name as string,
        patronymic: this.form.value.patronymic as string,
        country: this.form.value.country as string,
        region: this.form.value.region as string,
        city: this.form.value.city as string,
        phoneNumber: this.form.value.phoneNumber as string,
        index: this.form.value.index as number
      }
      this.clientService.updateClient(client as Client)
        .subscribe(c => {
          alert('Клиент сохранен. Вы будете перенаправлены на страницу с клиентом.');
          this.instance = c;
          this.editingMode = false;
        })
    }
  }

  public form = new FormGroup({
    surname: new FormControl(this.instance?.surname, [
      Validators.required,
      Validators.minLength(3)
    ]),
    name: new FormControl(this.instance?.name, [
      Validators.required,
      Validators.minLength(3)
    ]),
    patronymic: new FormControl(this.instance?.patronymic, [
      Validators.required,
      Validators.minLength(3)
    ]),
    country: new FormControl(this.instance?.country, [
      Validators.required,
      Validators.minLength(3)
    ]),
    region: new FormControl(this.instance?.region, [
      Validators.required,
      Validators.minLength(3)
    ]),
    city: new FormControl(this.instance?.city, [
      Validators.required,
      Validators.minLength(3)
    ]),
    phoneNumber: new FormControl(this.instance?.phoneNumber, [
      Validators.required,
      Validators.minLength(3)
    ]),
    index: new FormControl(this.instance?.index, [
      Validators.required
    ])
  })

}
