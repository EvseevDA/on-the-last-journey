import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AffilationType} from "../model/affilation-type";
import {AffilationTypeDto} from "../model/affilation-type-dto";

@Injectable({
  providedIn: 'root'
})
export class AffilationTypeService {

  constructor(private http: HttpClient) {
  }

  private readonly SOURCE_URL: string = 'http://localhost:8081/api/affilation-types';

  public getAllAffilationTypes(): Observable<AffilationType[]> {
    return this.http.get<AffilationType[]>(this.SOURCE_URL);
  }

}
