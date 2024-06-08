import {NgModule} from '@angular/core';

import {EmployeeComponent} from './employee.component';
import {EmployeeRoutingModule} from "./employee-routing.module";
import {EmployeeService} from "../service/employee.service";
import {NgForOf} from "@angular/common";
import {RouterLink} from "@angular/router";

@NgModule({
  imports: [EmployeeRoutingModule, NgForOf, RouterLink],
  exports: [],
  declarations: [EmployeeComponent],
  providers: [EmployeeService],
})
export class EmployeeModule {
}
