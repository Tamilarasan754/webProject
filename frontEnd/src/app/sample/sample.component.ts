import { Component } from '@angular/core';
import { CommonServiceService } from '../service/common-service.service';

@Component({
  selector: 'app-sample',
  templateUrl: './sample.component.html',
  styleUrl: './sample.component.scss'
})
export class SampleComponent {
  constructor(private commonService: CommonServiceService){}
val:string|null=null;
  demo():void{
    this.commonService.getCommonApi("/hello").subscribe({
      next:(response:any)=>{
        console.log(response);
        this.val=response.name
      },
      error:(err:any)=>{
        console.warn(err);
      }
    })
  }

}
