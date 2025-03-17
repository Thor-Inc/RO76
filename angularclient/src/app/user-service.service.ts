import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userURL: string;

  constructor(private http: HttpClient) {
    this.userURL ="http://localhost:8080/users";
  }

  public findAll(): Observable<User[]>{
    return this.http.get<User[]>(this.userURL);
  }

  public save(user: User){
    return this.http.post<User>(this.userURL, user);
  }
}
