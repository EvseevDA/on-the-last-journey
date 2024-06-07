import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";
import {UserDto} from "../model/user-dto";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private readonly SOURCE_URL: string = 'http://localhost:8081/api/users';

  public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.SOURCE_URL);
  }

  public getUserById(id: number): Observable<User> {
    return this.http.get<User>(this.SOURCE_URL + '/' + id);
  }

  public getUserByLogin(login: string): Observable<User> {
    return this.http.get<User>(this.SOURCE_URL + `/by-login/${login}`);
  }

  public getUserByLoginAndPassword(login: string, password: string): Observable<User> {
    return this.http.get<User>(this.SOURCE_URL + `/${login}/${password}`);
  }

  public addUser(userDto: UserDto): Observable<User> {
    return this.http.post<User>(this.SOURCE_URL, userDto);
  }

  public updateUser(user: User): Observable<User> {
    return this.http.put<User>(this.SOURCE_URL, user);
  }

  public userExistsByLoginAndPassword(login: string, password: string): Observable<boolean> {
    return this.http.get<boolean>(this.SOURCE_URL + `/exists/${login}/${password}`);
  }

  public deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(this.SOURCE_URL + '/' + id);
  }

}
