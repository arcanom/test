import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { EnregistrementRequest } from '../model/enregistrement-request';
import { ModuleRequest } from '../model/module-request';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  url : string = "http://localhost:8080/";
  constructor(private http : HttpClient) {

   }


   getModules():Observable<any>{
    return this.http.get(this.url+"api/module/all")
   }

   createModule(module: ModuleRequest){
    return this.http.post(this.url+"api/module",module)
   }

   getEnregistrementbyModule(id:number ):Observable<any>{
    return this.http.get(this.url+"api/mistreatment/"+id)
   }

   createEnregistrement(enregistrement: EnregistrementRequest){
    return this.http.post(this.url+"api/mistreatment",enregistrement)
   }


}
