import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class CommonServiceService {

  constructor(private http:HttpClient) { }

  public getCommonApi(url:string){
       
    const apiuril=`http://localhost:8080${url}`
    return this.http.get<any>(apiuril);
    }
}
