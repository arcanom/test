import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EnregistrementRequest } from 'src/app/model/enregistrement-request';
import { HttpService } from 'src/app/service/http.service';

@Component({
  selector: 'app-enregistrement-form',
  templateUrl: './enregistrement-form.component.html',
  styleUrls: ['./enregistrement-form.component.css']
})
export class EnregistrementFormComponent implements OnInit {
  moduleId: number
  form !: FormGroup
  enregistrement !: EnregistrementRequest
  constructor(private fb: FormBuilder, private http : HttpService, private router: Router ) {
    this.moduleId =  parseInt(localStorage.getItem("moduleId"))
   }

  ngOnInit(): void {
    this.form = this.fb.group({
      date: this.fb.control('',[Validators.required]),
      rateMeasure: this.fb.control('',[Validators.required]),
      temperatureMeasure: this.fb.control('',[Validators.required])
    })
  }
  get date(){
    return this.form.get("date")
  }

  get rateMeasure(){
    return this.form.get("rateMeasure")
  }
  get temperatureMeasure(){
    return this.form.get("temperatureMeasure")
  }

  validateEnregistrement(){
    if(this.form.valid){
      this.enregistrement = {
        dateEnregistrement: this.form.value.date,
        rateMeasure: this.form.value.rateMeasure,
        temperatureMeasure: this.form.value.temperatureMeasure,
        moduleId : this.moduleId
      }
      this.http.createEnregistrement(this.enregistrement).subscribe(x=>{
        console.log(x)
      })
      this.router.navigate(['/enregistrement'])
    }
  }

}
