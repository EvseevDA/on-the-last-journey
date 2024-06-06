import {NgModule} from '@angular/core';

import {FuneralAffilationComponent} from './funeral-affilation.component';
import {FuneralAffilationRoutingModule} from "./funeral-affilation-routing.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {RouterLink} from "@angular/router";
import {FuneralAffilationService} from "../service/funeral-affilation.service";
import {SingletonAffilationComponent} from './singleton-affilation/singleton-affilation.component';
import {ProviderModule} from "../provider/provider.module";
import {AffilationTypeModule} from "../affilation-type/affilation-type.module";
import { AffilationAdditionComponent } from './affilation-addition/affilation-addition.component';

@NgModule({
  imports: [
    FuneralAffilationRoutingModule,
    FormsModule,
    NgForOf,
    RouterLink,
    ReactiveFormsModule,
    ProviderModule,
    AffilationTypeModule,
    NgIf
  ],
  exports: [],
  declarations: [
    FuneralAffilationComponent,
    SingletonAffilationComponent,
    AffilationAdditionComponent
  ],
  providers: [FuneralAffilationService],
})
export class FuneralAffilationModule {
}
