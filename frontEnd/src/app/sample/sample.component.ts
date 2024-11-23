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
}
