import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Category } from '../Types/category';
import { Observable } from 'rxjs';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  baseUrl:string  = environment.apiUrl;

  constructor(private http : HttpClient , private router:  Router, private userService : UserService) { }

  header = new HttpHeaders({
    Authorization: 'Bearer ' + this.userService.getTokenLocalStorage(),
  })

 

  addCategory(category : Category):Observable<Category>{
    return this.http.post<Category>(`${this.baseUrl}/food/category/add`, category, {headers :this.header});
  }

  getAllCategory(): Observable<Category[]>{
      return this.http.get<Category[]>(`${this.baseUrl}/food/category/all`,{headers :this.header});
  }

  deleteCategory(id:number):Observable<String> {
    return   this.http.delete<string>(`${this.baseUrl}/food/category/${id}` , {headers :this.header})
  }


}
