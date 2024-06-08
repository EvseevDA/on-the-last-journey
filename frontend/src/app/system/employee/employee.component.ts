import {Component, LOCALE_ID, OnInit} from '@angular/core';
import {EmployeeService} from "../service/employee.service";
import {Employee} from "../model/employee";
import {Util} from "../../../util/util";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css', '../system.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private employeeService: EmployeeService,) {
  }

  public employees: Employee[] = [];

  public employeeCount: number = 0;

  public util: Util = new Util();

  public timestamp: string = (new Date(Date.now()).toLocaleDateString());

  ngOnInit(): void {
    this.employeeService.getAllEmployeesOrderedByFullName()
      .subscribe(es =>
        es.forEach(e => this.employees.push(e)));

    this.employeeService.getTotalEmployeeCount()
      .subscribe(c => this.employeeCount = c);
  }

  protected readonly Date = Date;
  protected readonly LOCALE_ID = LOCALE_ID;
}
