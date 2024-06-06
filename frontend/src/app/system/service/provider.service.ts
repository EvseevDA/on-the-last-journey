import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Provider} from "../model/provider";

@Injectable({
  providedIn: 'root'
})
export class ProviderService {

  constructor(private http: HttpClient) { }

  private readonly SOURCE_URL: string = 'http://localhost:8081/api/providers';

  public getAllProviders(): Observable<Provider[]> {
    return this.http.get<Provider[]>(this.SOURCE_URL);
  }
}
