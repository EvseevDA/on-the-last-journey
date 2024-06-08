import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../model/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  private readonly SOURCE_URL: string = 'http://localhost:8081/api/employees';

  public getAllEmployeesOrderedByHireDate(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.SOURCE_URL + '/ordered-by/hire-date');
  }

  public getAllEmployeesOrderedByFullName(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.SOURCE_URL + '/ordered-by/full-name');
  }

  public getTotalEmployeeCount(): Observable<number> {
    return this.http.get<number>(this.SOURCE_URL + '/count')
  }

}
