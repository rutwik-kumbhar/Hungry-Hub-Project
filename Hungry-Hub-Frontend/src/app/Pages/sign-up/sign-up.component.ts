import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { userSignUp } from 'src/app/Types/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  constructor(private userService:UserService,private router:Router){}

  userSignUp(userData:userSignUp){
      this.userService.registerUser(userData).subscribe((res)=>{
          console.log(res);
      },(error)=>{
          alert("Unable to create account..!")
          console.log(error);
      },()=>{
          alert("User account created successfully..!")
          this.router.navigate(['/sign-in']);
      })
      
    
  }
}
