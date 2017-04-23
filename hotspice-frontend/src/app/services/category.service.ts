import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import {Category} from '../models/Category';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';

@Injectable()
export class CategoryService{
	constructor(private http: Http){
		console.log('CategoryService initialized...')
	}

	getCategories(): Observable<Category[]> {
  		const url = 'http://ec2-54-255-199-213.ap-southeast-1.compute.amazonaws.com:8080/categories';
  		return this.http.get(url)
    		.map(res => res.json())
    				.catch(this.handleError);
	}

	private handleError(error: any): Promise<any> {
  		console.error('An error occurred', error); // for demo purposes only
  		return Promise.reject(error.message || error);
	}
}