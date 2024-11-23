import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild, ViewEncapsulation } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CommonService } from '../service/common.service';
import { error } from 'console';


@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrl: './loginpage.component.scss',
 
})
export class LoginpageComponent {
  val: any;
  constructor(private commonService:CommonService){

  }

logUpPage=new FormGroup({
  email:new FormControl<String|null>('',Validators.required),
  name:new FormControl<String|null>('',Validators.required),
  password:new FormControl<String|null>('',Validators.required)
})
loginPage=new FormGroup({
  usEmail:new FormControl<String|null>('',Validators.required),
  usPassword:new FormControl<String|null>('',Validators.required)
})
@ViewChild('container') container!: ElementRef;

signIn() {
  this.container.nativeElement.classList.remove('right-panel-active');
}

signUp() {
  this.container.nativeElement.classList.add('right-panel-active');
}
signupVal():void{
  console.log(this.logUpPage.value);
  const newUser=this.logUpPage.value;
 this.commonService.postCommonApi('/auth',newUser).subscribe({
  next:(value:any)=>{
    console.log(value);
  },
  error:(err:any)=>
  {
    console.error(err);
  }
 })
}
signInVal():void{
  console.log(this.loginPage.value);
  this.demo();
}
demo(): void {
  this.commonService.getCommonApi("/hello").subscribe({
    next: (response: any) => {
      console.log(response);
      this.val = response.name;
    },
    error: (err: any) => {
      console.warn(err);
    }
  });
}

}
