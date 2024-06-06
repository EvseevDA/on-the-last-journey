import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppModule} from "./app.module";

@NgModule({
  imports: [
    AppModule
  ],
  exports: [],
  declarations: [AppComponent],
  providers: [],
})
export class AppServerModule {
}
