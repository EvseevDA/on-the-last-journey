import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FuneralAffilation} from "../model/funeral-affilation";
import {FuneralAffilationDto} from "../model/funeral-affilation-dto";

@Injectable({
  providedIn: 'root'
})
export class FuneralAffilationService {

  constructor(private http: HttpClient) { }

  private readonly SOURCE_URL: string = 'http://localhost:8081/api/funeral-affilations';

  public getAllAffilations(): Observable<FuneralAffilation[]> {
    return this.http.get<FuneralAffilation[]>(this.SOURCE_URL);
  }

  public getAffilationById(id: number): Observable<FuneralAffilation> {
    return this.http.get<FuneralAffilation>(this.SOURCE_URL + '/' + id);
  }

  public addAffilation(affilationDto: FuneralAffilationDto): Observable<FuneralAffilation> {
    return this.http.post<FuneralAffilation>(this.SOURCE_URL, affilationDto);
  }

  public updateAffilation(affilation: FuneralAffilation): Observable<FuneralAffilation> {
    return this.http.put<FuneralAffilation>(this.SOURCE_URL, affilation);
  }

  public deleteAffilation(id: number): Observable<void> {
    return this.http.delete<void>(this.SOURCE_URL + '/' + id);
  }
}
