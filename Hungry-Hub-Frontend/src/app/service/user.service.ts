import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginResponse, UserSignIn, userSignUp } from '../Types/user';
import { Observable } from 'rxjs';
import { Token } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl:string = environment.apiUrl;

  header  = new HttpHeaders({
    Authorization: 'Bearer ' + this.getTokenLocalStorage(),
  })

  constructor(private http:HttpClient) { 
      
  }

  registerUser(data: userSignUp): Observable<userSignUp> {
    return this.http.post<userSignUp>(`${this.baseUrl}/auth/user/sign/up`, data);
  }

  loginUser(data:UserSignIn):Observable<LoginResponse>{
    return this.http.post<LoginResponse>(`${this.baseUrl}/auth/user/sign/in` ,data);
  }

  getUserDeatilsByjwt():Observable<userSignUp>{
      return this.http.get<userSignUp>(`${this.baseUrl}/user/jwt`, {headers: this.header})
  }


  setTokenLocalStorage(token : string){
      localStorage.setItem("token" , token);
  }

  getTokenLocalStorage():any{       
    return localStorage.getItem("token");
  }

  isUserLogin():boolean{
    let  token = this.getTokenLocalStorage();
    return token != undefined? true : false;
  }

  clearLocalStorage(){
    localStorage.clear();
  }
}
