import { Component } from '@angular/core';
import { DishService } from '../services/dish.service'; 
import {Dish} from '../models/Dish';

@Component({
	moduleId: module.id,
  	selector: 'dishes',
  	templateUrl: 'dish.component.html',
  	providers: [DishService],
})

export class DishComponent {
	
	dish: Dish[];
	constructor(private dishService: DishService){
		console.log("DishComponent Initialized...")
		this.dishService.getDishes()
      		.subscribe(
                       dishes => {
				this.dish = dishes;
            })
		};
	}