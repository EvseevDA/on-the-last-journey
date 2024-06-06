import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../model/order";
import {OrderDto} from "../model/order-dto";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  private readonly SOURCE_URL: string = 'http://localhost:8081/api/orders';

  public getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.SOURCE_URL);
  }

  public getOrderById(id: number): Observable<Order> {
    return this.http.get<Order>(this.SOURCE_URL + '/' + id);
  }

  public addOrder(orderDto: OrderDto): Observable<Order> {
    return this.http.post<Order>(this.SOURCE_URL, orderDto);
  }

  public updateOrder(order: Order): Observable<Order> {
    return this.http.put<Order>(this.SOURCE_URL, order);
  }

  public deleteOrder(id: number): Observable<void> {
    return this.http.delete<void>(this.SOURCE_URL + '/' + id);
  }

}
