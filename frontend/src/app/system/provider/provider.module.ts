import {NgModule} from '@angular/core';

import {ProviderComponent} from './provider.component';
import {ProviderRoutingModule} from "./provider-routing.module";
import {NgForOf} from "@angular/common";
import {RouterLink} from "@angular/router";
import {ProviderService} from "../service/provider.service";

@NgModule({
  imports: [ProviderRoutingModule, NgForOf, RouterLink],
  exports: [],
  declarations: [ProviderComponent],
  providers: [ProviderService],
})
export class ProviderModule {
}
