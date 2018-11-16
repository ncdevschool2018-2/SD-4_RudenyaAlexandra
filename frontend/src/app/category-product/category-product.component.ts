import { Component, OnDestroy, OnInit } from '@angular/core';
import { CategoryData } from '../sharedData/category';
import { CategoryService } from '../service/category.service';
import { ProductData } from '../sharedData/product';
import { ProductService } from '../service/product.service';
import { PageChangedEvent } from 'ngx-bootstrap/pagination';

@Component ({
    selector: 'app-category-product',
    templateUrl: './category-product.component.html',
    styleUrls: ['./category-product.component.css']
})

export class CategoryProductComponent implements OnInit, OnDestroy {

    public category = new CategoryData(this.categoryService);
    public product = new ProductData(this.productService);

    ngOnInit(): void {
        this.category.ngOnInit();
        this.product.ngOnInit();
    }

    constructor( private categoryService: CategoryService, private productService: ProductService ) {}

    ngOnDestroy(): void {
    }
}
