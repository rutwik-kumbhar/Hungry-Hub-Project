import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './Pages/sign-up/sign-up.component';
import { HomeComponent } from './Components/home/home.component';
import { SignInComponent } from './Pages/sign-in/sign-in.component';



const routes: Routes = [
  {path:"", component : HomeComponent},
  {path:"home" ,component:HomeComponent,},
  {path: "sign-up" , component:SignUpComponent},
  {path:"sign-in",component:SignInComponent },
  {},
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
