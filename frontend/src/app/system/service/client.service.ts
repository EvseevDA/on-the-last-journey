import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../model/client";
import {ClientDto} from "../model/client-dto";

@Injectable({
  providedIn: "root"
})
export class ClientService {

  private readonly SOURCE_URL: string = 'http://localhost:8081/api/clients'

  constructor(private http: HttpClient) {
  }

  public getAllClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.SOURCE_URL);
  }

  public getClientById(id: number): Observable<Client> {
    return this.http.get<Client>(this.SOURCE_URL + '/' + id);
  }

  public addClient(clientDto: ClientDto): Observable<Client> {
    return this.http.post<Client>(this.SOURCE_URL, clientDto);
  }

  public updateClient(client: Client): Observable<Client> {
    return this.http.put<Client>(this.SOURCE_URL, client);
  }

  public deleteClient(id: number): Observable<void> {
    return this.http.delete<void>(this.SOURCE_URL + '/' + id);
  }

}
