import { Component } from '@angular/core';
import { userSignUp } from 'src/app/Types/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  user:userSignUp | undefined;

  
  
  constructor(private userService : UserService){};

  

  userProfile(){
    this.userService.getUserDeatilsByjwt().subscribe((res)=>{
      this.user = res;
          console.log(res)
    },(error)=>{
        console.log(error)
    },()=>{
        console.log("profile success")
    })
  }


  isUserLogin():boolean{
    return this.userService.isUserLogin();
  }

  userLogout(){
    this.userService.clearLocalStorage();
  }

}
