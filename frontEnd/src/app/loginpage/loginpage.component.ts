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
  value: any=null;
  constructor(private commonService: CommonService) {

  }

  logUpPage = new FormGroup({
    email: new FormControl<String | null>('', Validators.required),
    name: new FormControl<String | null>('', Validators.required),
    password: new FormControl<String | null>('', Validators.required)
  })
  loginPage = new FormGroup({
    usEmail: new FormControl<String | null>('', Validators.required),
    usPassword: new FormControl<String | null>('', Validators.required)
  })
  @ViewChild('container') container!: ElementRef;

  signIn() {
    this.container.nativeElement.classList.remove('right-panel-active');
  }

  signUp() {
    this.container.nativeElement.classList.add('right-panel-active');
  }
  signupVal(): void {
    console.log(this.logUpPage.value);
    const newUser = this.logUpPage.value;
    this.commonService.postCommonApi('/api/auth/register', newUser).subscribe({
      next: (value: any) => {
        this.value=value;
        console.log(value);
      },
      error: (err: any) => {
        console.error(err);
      }
    })
  }
  signInVal(): void {
    console.log("Toko", this.loginPage.value);
    const loginUser = this.logUpPage.value;
    if (this.loginPage.value) {
      const login= {
        email: this.loginPage.value.usEmail,
        password:this.loginPage.value.usPassword
    }
    this.demo(login);
  }
}
demo(loginUser: any): void {
  this.commonService.postCommonApi("/api/auth/login", loginUser).subscribe({
    next: (response: any) => {
      console.log("reas",response);
      this.val = response.message;
    },
    error: (err: any) => {
      console.warn(err);
    }
  });
}

}
