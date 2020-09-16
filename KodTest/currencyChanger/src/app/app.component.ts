import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { strict } from 'assert';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private http:HttpClient) {}

  public getCurrencies() {
    return this.http.get("http://localhost:8080/symbols");
  }

  public getChange(from, to, value) {
    return this.http.get(new URL("http://localhost:8080/convert?from=" + from + "&to=" + to + "&value=" + value));
  }
}
