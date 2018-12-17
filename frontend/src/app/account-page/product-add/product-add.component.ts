import { Component, OnInit } from '@angular/core';
import {ProductData} from '../../sharedData/product';
import { ProductService } from 'src/app/service/product.service';
import { CategoryService } from 'src/app/service/category.service';
import { CategoryData } from 'src/app/sharedData/category';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';


@Component({
    selector: 'app-add-product',
    templateUrl: './product-add.component.html',
    styleUrls: ['./product-add.component.css'],
})

export class AddProductComponent implements OnInit  {

    model = 0;
    public product: ProductData =  new ProductData(this.productService, this.loading);
    public category: CategoryData = new CategoryData(this.categoryService);
    ngOnInit(): void {
      this.product.ngOnInit();
      this.category.ngOnInit();
    }

    constructor(private productService: ProductService, private categoryService: CategoryService,
        private loading: Ng4LoadingSpinnerService) {
    }

    getCategoryName(nameCategory: string) {
        this.product.editProduct.category.nameCategory = nameCategory;
        console.log(this.product.editProduct.category.nameCategory);
    }


}
