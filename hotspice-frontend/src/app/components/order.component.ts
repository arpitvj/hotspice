import { Component } from '@angular/core';
import { OrderService } from '../services/order.service'; 
import {Order} from '../models/Order';

@Component({
	moduleId: module.id,
  	selector: 'order',
  	templateUrl: 'order.component.html',
  	providers: [OrderService],
})
export class OrderComponent {
	
	order: Order[];
	constructor(private orderService: OrderService){
		console.log("OrderComponent Initialized...")
		this.orderService.getOrders()
      		.subscribe(
                       orders => {
				this.order = orders;
            })
		};
	}