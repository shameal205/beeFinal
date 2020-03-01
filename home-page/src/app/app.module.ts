import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import {MatTableModule} from '@angular/material/table';

import {HttpClientModule} from '@angular/common/http';

import {BeeService} from './services/bee.service';
import { BeeTableComponent } from './bee-table/bee-table.component';


@NgModule({
  declarations: [
    AppComponent,
    BeeTableComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatTableModule,
    HttpClientModule
  ],
  providers: [BeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
