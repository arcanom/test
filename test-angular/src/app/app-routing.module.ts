import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ModuleComponent } from './component/module/module.component';
import { ModuleFormComponent } from './component/module-form/module-form.component';
import { EnregistrementComponent } from './component/enregistrement/enregistrement.component';
import { EnregistrementFormComponent } from './component/enregistrement-form/enregistrement-form.component';

const routes: Routes = [

 {path:"module",component:ModuleComponent},
 {path:"module-form",component:ModuleFormComponent},
 {path:"enregistrement",component:EnregistrementComponent},
 {path:"enregistrement-form",component:EnregistrementFormComponent},
 {path:"",component:ModuleComponent}
]


@NgModule({

  imports: [RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule { }
