import { Component, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/service/http.service';

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent implements OnInit {
modules: any = null
  constructor(private http: HttpService, private route: Router) {

   }

  getModules(){
    this.http.getModules().subscribe(module=>{
      console.log(module)
      this.modules =  module;
    })
  }

  ngOnInit(): void {
    this.getModules()
  }
  ngOnChanges(changes: SimpleChanges) {
    this.getModules()
  }

  redirectToEnregistrement(id:any){

      localStorage.setItem("moduleId",id)
      this.route.navigate(['/enregistrement'])
  }


}
