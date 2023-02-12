
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ModuleRequest } from 'src/app/model/module-request';
import { HttpService } from 'src/app/service/http.service';

@Component({
  selector: 'app-module-form',
  templateUrl: './module-form.component.html',
  styleUrls: ['./module-form.component.css']
})
export class ModuleFormComponent implements OnInit {
form !: FormGroup
module !: ModuleRequest
  constructor(private fb: FormBuilder, private http : HttpService, private router: Router) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: this.fb.control('',[Validators.required]),
      state : this.fb.control('',[Validators.required])
    })
  }

  get name(){
    return this.form.get("name")
  }

  get state(){
    return this.form.get("state")
  }

validateModule(){
  if(this.form.valid){
    this.module = {
      name: this.form.value.name,
      state : JSON.parse(this.form.value.state)
    }
    this.http.createModule(this.module).subscribe(x=>{
      console.log(x)
    })

    this.router.navigate(['/module'])
  }
}

}
