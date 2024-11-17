import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild, ViewEncapsulation } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrl: './loginpage.component.scss',
 
})
export class LoginpageComponent {

logUpPage=new FormGroup({
  uemail:new FormControl<String|null>('',Validators.required),
  uname:new FormControl<String|null>('',Validators.required),
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
}
signInVal():void{
  console.log(this.loginPage.value);
}

}
