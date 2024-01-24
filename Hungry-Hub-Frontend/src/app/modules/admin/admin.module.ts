import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { CategoryComponent } from '../Components/category/category.component';
import { AdminDashboardComponent } from '../Components/admin-dashboard/admin-dashboard.component';



@NgModule({
  declarations: [
    AdminDashboardComponent,
    CategoryComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class AdminModule { }
