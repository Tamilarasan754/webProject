import { Component } from '@angular/core';
import { CommonService } from '../service/common.service';

@Component({
  selector: 'app-sample',
  templateUrl: './sample.component.html',
  styleUrls: ['./sample.component.scss'] // Corrected styleUrls property
})
export class SampleComponent {
  val: string | null = null;

  constructor(private commonService: CommonService) { }

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
  isActive = false;
  resultText = '';

  searchToggle(event: Event): void {
    event.preventDefault();
    this.isActive = !this.isActive;

    if (!this.isActive) {
      const searchInput = document.querySelector('.search-input') as HTMLInputElement;
      if (searchInput) {
        searchInput.value = '';
      }
      this.resultText = '';
    }
  }

  submitFn(form: any, event: Event): void {
    event.preventDefault();
    const value = form.value.searchText.trim();

    if (!value.length) {
      this.resultText = 'Yup yup! Add some text friend :D';
    } else {
      this.resultText = `Yup yup! Your search text sounds like this: <b>${value}</b>`;
    }
  }
}




