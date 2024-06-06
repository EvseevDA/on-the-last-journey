import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OrderService} from "../service/order.service";
import {Order} from "../model/order";
import {Util} from "../../../util/util";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css', '../system.component.css']
})
export class OrderComponent implements OnInit {
  constructor(private orderService: OrderService,
              private router: Router,
              private route: ActivatedRoute) {

  }

  public util: Util = new Util();

  public orders: Order[] = [];

  public selectedOrderId: number = 0;

  public getSingletonOrder(id: number | undefined): void {
    this.router.navigate([`${id}`], { relativeTo: this.route })
  }

  ngOnInit(): void {
    this.orderService.getAllOrders()
      .subscribe(os => {
        os.forEach(o => {
          this.orders.push(o)
        });
      });
    this.selectedOrderId = this.orders[0].id;
  }

}
