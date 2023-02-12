import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ModuleComponent } from './component/module/module.component';
import { ModuleFormComponent } from './component/module-form/module-form.component';
import { EnregistrementComponent } from './component/enregistrement/enregistrement.component';
import { EnregistrementFormComponent } from './component/enregistrement-form/enregistrement-form.component';
@NgModule({
  declarations: [
    AppComponent,
    ModuleComponent,
    ModuleFormComponent,
    EnregistrementComponent,
    EnregistrementFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
