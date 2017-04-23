import { Component } from '@angular/core';
import { CategoryService } from '../services/category.service'; 
import {Category} from '../models/Category';

@Component({
	moduleId: module.id,
  	selector: 'category',
  	templateUrl: 'category.component.html',
  	providers: [CategoryService],
})
export class CategoryComponent {
	
	category: Category[];
	show: boolean = false;

	constructor(private categoryService: CategoryService){
		console.log("CategoryComponent Initialized...")
		this.categoryService.getCategories()
      		.subscribe(
                categories => {
			this.category = categories;
        })
	};

	
}