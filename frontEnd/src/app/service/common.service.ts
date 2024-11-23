import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class CommonService {
  constructor(private http: HttpClient) {}

  public postCommonApi(url: string, data: any) {
    const apiUrl = `http://localhost:8080${url}`;
    return this.http.post<any>(apiUrl, data);
  }

  public getCommonApi(url: string) {
    const apiUrl = `http://localhost:8080${url}`;
    return this.http.get<any>(apiUrl);
  }
}
