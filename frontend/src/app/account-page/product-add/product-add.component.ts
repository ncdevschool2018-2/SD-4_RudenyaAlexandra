import { Component, OnInit } from '@angular/core';
import {ProductData} from '../../sharedData/product';
import { ProductService } from 'src/app/service/product.service';
import { CategoryService } from 'src/app/service/category.service';
import { CategoryData } from 'src/app/sharedData/category';

@Component({
    selector: 'app-add-product',
    templateUrl: './product-add.component.html',
    styleUrls: ['./product-add.component.css'],
})

export class AddProductComponent implements OnInit  {

    model = 0;
    public product: ProductData =  new ProductData(this.productService);
    public category: CategoryData = new CategoryData(this.categoryService);
    ngOnInit(): void {
      //this.product.editProduct.category.categoryId = this.model;
      this.product.ngOnInit();
      this.category.ngOnInit();
    }

    constructor(private productService: ProductService, private categoryService: CategoryService) {
    }
}
