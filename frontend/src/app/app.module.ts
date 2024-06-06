import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {NavigationComponent} from './common-component/navigation/navigation.component';
import {RouterLink, RouterLinkActive, RouterOutlet} from "@angular/router";
import {FooterComponent} from './common-component/footer/footer.component';
import {ErrorComponent} from './error/error/error.component';
import {AppRoutingModule} from "./app-routing.module";
import { SystemComponent } from './system/system/system.component';
import { ClientComponent } from './system/client/client.component';
import { HomePageComponent } from './home-page/home-page/home-page.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    FooterComponent,
    ErrorComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    RouterOutlet,
    AppRoutingModule,
    RouterLink,
    RouterLinkActive
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
