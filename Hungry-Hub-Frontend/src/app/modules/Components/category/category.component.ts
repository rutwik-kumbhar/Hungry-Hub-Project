import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/Types/category';
import { CategoryService } from 'src/app/service/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories !: Category[];

constructor(private categoryService : CategoryService , private router : Router){
  this.getAllCategorised();
};

ngOnInit(): void {
  this.getAllCategorised();
}

  addCategory(category:Category) {
     this.categoryService.addCategory(category).subscribe((res)=>{
     },(error)=>{
      alert("Category Alredy Added")
        console.log(error);
     },()=>{
      this.getAllCategorised();
        alert("Category Added");
     })
  }

  getAllCategorised(){
    this.categoryService.getAllCategory().subscribe((res)=>{
       this.categories = res;
    },(error)=>{
        console.log(error);
    },()=>{
        console.log("category Success");
    })
  }

  deleteCategory(id : number) {
    this.categoryService.deleteCategory(id).subscribe((res)=>{
        console.log(res)
    },(error)=>{
        console.log(error);
    },()=>{
      this.getAllCategorised();
      alert("Category Deleted Successfully...!");
    })
  }


}
