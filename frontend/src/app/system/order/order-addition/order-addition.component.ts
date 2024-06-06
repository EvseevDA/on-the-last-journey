import {Component, OnInit} from '@angular/core';
import {Client} from "../../model/client";
import {Order} from "../../model/order";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {OrderService} from "../../service/order.service";
import {ClientService} from "../../service/client.service";
import {Util} from "../../../../util/util";
import {OrderDto} from "../../model/order-dto";

@Component({
  selector: 'app-order-addition',
  templateUrl: './order-addition.component.html',
  styleUrls: ['./order-addition.component.css', '../../system.component.css']
})
export class OrderAdditionComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private orderService: OrderService,
              private router: Router,
              private clientService: ClientService) {
  }

  public clients: Client[] = [];

  public selectedClientId!: number;

  public util: Util = new Util();

  public ngOnInit(): void {
    this.clientService.getAllClients().subscribe(
      cs => cs.forEach(c => {
        this.clients.push(c)
      })
    );
  }

  public submit(): void {
    if (this.form.valid) {
      let clientInOrder: Client = this.clients.filter(c => c.id == this.selectedClientId).at(0) as Client;
      console.log(clientInOrder)
      let order: OrderDto = {
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
      this.orderService.addOrder(order as Order)
        .subscribe(o => {
          alert('Заказ сохранен. Вы будете перенаправлены на страницу с заказами.');
          this.router.navigate(['../../'], { relativeTo: this.route });
        });
    }
  }

  public form = new FormGroup({
    registrationYear: new FormControl(0, [
      Validators.required
    ]),
    registrationMonth: new FormControl(0, [
      Validators.required
    ]),
    registrationDate: new FormControl(0, [
      Validators.required
    ]),
    appointmentYear: new FormControl(0, [
      Validators.required
    ]),
    appointmentMonth: new FormControl(0, [
      Validators.required
    ]),
    appointmentDate: new FormControl(0, [
      Validators.required
    ]),
    executionYear: new FormControl(0, [
      Validators.required
    ]),
    executionMonth: new FormControl(0, [
      Validators.required
    ]),
    executionDate: new FormControl(0, [
      Validators.required
    ]),
  })

}
