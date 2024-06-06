import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ClientService} from "../../service/client.service";
import {Client} from "../../model/client";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {OrderService} from "../../service/order.service";
import {Order} from "../../model/order";
import {Util} from "../../../../util/util";

@Component({
  selector: 'app-singleton-order',
  templateUrl: './singleton-order.component.html',
  styleUrls: ['./singleton-order.component.css', '../../system.component.css']
})
export class SingletonOrderComponent implements OnInit {
  constructor(private route: ActivatedRoute,
              private orderService: OrderService,
              private router: Router,
              private clientService: ClientService) {
  }

  public instance!: Order;

  public clients: Client[] = [];

  public selectedClientId!: number;

  public editingMode: boolean = false;

  public util: Util = new Util();

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.orderService.getOrderById(params['id']).subscribe(o => {
        this.instance = o;
        this.selectedClientId = this.instance.client.id;
        this.clientService.getAllClients().subscribe(
          cs => cs.forEach(c => {
            this.clients.push(c)
          })
        );
        console.log(1)
      });
    });
  }

  public edit(): void {
    this.editingMode = true;

    this.form.get('registrationDate')?.setValue(this.instance.registrationDate[2]);
    this.form.get('registrationMonth')?.setValue(this.instance.registrationDate[1]);
    this.form.get('registrationYear')?.setValue(this.instance.registrationDate[0]);

    this.form.get('appointmentDate')?.setValue(this.instance.appointmentDate[2]);
    this.form.get('appointmentMonth')?.setValue(this.instance.appointmentDate[1]);
    this.form.get('appointmentYear')?.setValue(this.instance.appointmentDate[0]);

    this.form.get('executionDate')?.setValue(this.instance.executionDate[2]);
    this.form.get('executionMonth')?.setValue(this.instance.executionDate[1]);
    this.form.get('executionYear')?.setValue(this.instance.executionDate[0]);
  }

  public cancelEditing(): void {
    this.editingMode = false;
  }

  public deleteById(id: number): void {
    let deletionConfirmed: boolean = confirm(`Вы действительно хотите удалить заказ с id ${id}?`);
    if (deletionConfirmed) {
      this.orderService.deleteOrder(id).subscribe(_ => {
        console.log(id);
        alert('Заказ удален, вы будете перенаправлены на страницу с заказами');
        this.router.navigate(['../'], {relativeTo: this.route});
      });
    }
  }

  public submit(): void {
    if (this.form.valid) {
      let clientInOrder: Client = this.clients.filter(c => c.id == this.selectedClientId).at(0) as Client;
      console.log(clientInOrder)
      let order: Order = {
        id: this.instance.id,
        client: clientInOrder,
        registrationDate: this.util.createDateArrayByDateData(
          this.form.value.registrationDate as number,
          this.form.value.registrationMonth as number,
          this.form.value.registrationYear as number
        ),
        appointmentDate: this.util.createDateArrayByDateData(
          this.form.value.appointmentDate as number,
          this.form.value.appointmentMonth as number,
          this.form.value.appointmentYear as number
        ),
        executionDate: this.util.createDateArrayByDateData(
          this.form.value.executionDate as number,
          this.form.value.executionMonth as number,
          this.form.value.executionYear as number
        )
      }
      console.log(order)
      this.orderService.updateOrder(order as Order)
        .subscribe(o => {
          alert('Заказ сохранен. Вы будете перенаправлены на страницу с клиентом.');
          this.instance = o;
          this.editingMode = false;
        })
    }
  }

  public form = new FormGroup({
    registrationYear: new FormControl(this.instance?.registrationDate[0], [
      Validators.required
    ]),
    registrationMonth: new FormControl(this.instance?.registrationDate[1], [
      Validators.required
    ]),
    registrationDate: new FormControl(this.instance?.registrationDate[2], [
      Validators.required
    ]),
    appointmentYear: new FormControl(this.instance?.appointmentDate[0], [
      Validators.required
    ]),
    appointmentMonth: new FormControl(this.instance?.appointmentDate[1], [
      Validators.required
    ]),
    appointmentDate: new FormControl(this.instance?.appointmentDate[2], [
      Validators.required
    ]),
    executionYear: new FormControl(this.instance?.executionDate[0], [
      Validators.required
    ]),
    executionMonth: new FormControl(this.instance?.executionDate[1], [
      Validators.required
    ]),
    executionDate: new FormControl(this.instance?.executionDate[2], [
      Validators.required
    ]),
  })
}
