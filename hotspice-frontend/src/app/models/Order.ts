import {Dish} from './Dish';

export class Order{
	customerOrderId: string;
	orderedDishes: Dish[];
	status: string;
	statusCode: string;
	placedAt: number;
}