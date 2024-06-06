import {NgModule} from '@angular/core';

import {AffilationTypeComponent} from './affilation-type.component';
import {AffilationTypeRoutingModule} from "./affilation-type-routing.module";
import {FormsModule} from "@angular/forms";
import {NgForOf} from "@angular/common";
import {RouterLink} from "@angular/router";
import {AffilationTypeService} from "../service/affilation-type.service";

@NgModule({
  imports: [AffilationTypeRoutingModule, FormsModule, NgForOf, RouterLink],
  exports: [],
  declarations: [AffilationTypeComponent],
  providers: [AffilationTypeService],
})
export class AffilationTypeModule {
}
