import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { StompService } from './services/stomp.service';
import { VehicleComponent } from './vehicle/vehicle.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    VehicleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [StompService],
  bootstrap: [AppComponent]
})
export class AppModule { }
