import { Component, OnInit, SimpleChanges } from '@angular/core';
import { HttpService } from 'src/app/service/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-enregistrement',
  templateUrl: './enregistrement.component.html',
  styleUrls: ['./enregistrement.component.css']
})
export class EnregistrementComponent implements OnInit {
moduleId !: number
enregistrements : any = null
  constructor(private http: HttpService, private router: Router) {
   this.moduleId =  parseInt(localStorage.getItem("moduleId"))
    this.getEnregistrementbyModuleId(this.moduleId)
   }

   getEnregistrementbyModuleId(id:number){
    this.http.getEnregistrementbyModule(id).subscribe(e=>{
      console.log(e)
      this.enregistrements = e
    })
   }

  ngOnInit(): void {
  }
  ngOnChanges(changes: SimpleChanges) {
    this.getEnregistrementbyModuleId(this.moduleId)
  }


}
