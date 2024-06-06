import {NgModule} from '@angular/core';

import {ClientComponent} from './client.component';
import {SingletonClientComponent} from "./singleton-client/singleton-client.component";
import {ClientRoutingModule} from "./client-routing.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {RouterLink} from "@angular/router";
import {ClientAdditionComponent} from "./client-addition/client-addition.component";

@NgModule({
  imports: [ClientRoutingModule, FormsModule, CommonModule, RouterLink, ReactiveFormsModule],
  exports: [],
  declarations: [ClientComponent, SingletonClientComponent, ClientAdditionComponent],
  providers: [],
})
export class ClientModule {
}
