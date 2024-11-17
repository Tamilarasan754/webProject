import { NgModule } from '@angular/core';
import { ServerModule } from '@angular/platform-server';

import { AppModule } from './app.module';
import { AppComponent } from './app.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { provideHttpClient } from '@angular/common/http';

@NgModule({
  imports: [
    AppModule,
    ServerModule

  ],
  providers:[],
  bootstrap: [AppComponent],
})
export class AppServerModule {}
