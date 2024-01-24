import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginResponse, UserSignIn } from 'src/app/Types/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  loginResponse : LoginResponse | undefined;

  constructor(private userService : UserService , private router : Router,){}

  userSignIn(data:UserSignIn){
    this.userService.loginUser(data).subscribe((res)=>{
       this.userService.setTokenLocalStorage(res.token);
    },(error)=>{
      console.log(error);
        alert('enter Correct Username and Password');
    },()=>{
        alert("Loging Successfully..!");
        this.router.navigate(['/home'])
    })  
  }

}
