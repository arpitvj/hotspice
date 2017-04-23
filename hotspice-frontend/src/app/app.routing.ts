import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {CategoryComponent} from './components/category.component';
import {DishComponent} from './components/dish.component';
import {OrderComponent} from './components/order.component';

const appRoutes: Routes = [

	{
		path: '',
		component: CategoryComponent

	},
	{
		path: 'dishes',
		component: DishComponent

	},
	{
		path: 'orders',
		component: OrderComponent

	}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);