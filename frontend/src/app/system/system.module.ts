import {NgModule} from '@angular/core';

import {SystemComponent} from './system/system.component';
import {SystemRoutingModule} from "./system-routing.module";
import {RouterLink, RouterOutlet} from "@angular/router";
import {ClientService} from "./service/client.service";
import {NgForOf} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { ClientAdditionComponent } from './client/client-addition/client-addition.component';
import { OrderComponent } from './order/order.component';
import {OrderService} from "./service/order.service";
import {ClientModule} from "./client/client.module";
import { AffilationTypeComponent } from './affilation-type/affilation-type.component';
import { ProviderComponent } from './provider/provider.component';
import { FuneralAffilationComponent } from './funeral-affilation/funeral-affilation.component';

@NgModule({
  imports: [
    SystemRoutingModule,
    RouterLink,
    NgForOf,
    HttpClientModule,
    FormsModule,
    RouterOutlet
  ],
  exports: [],
  declarations: [
    SystemComponent,
  ],
  providers: [ClientService, OrderService],
})
export class SystemModule {
}
