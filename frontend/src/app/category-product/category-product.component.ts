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

    rotate = true;
    contentArray = new Array(90).fill('');
    returnedArray: string[];
    public category = new CategoryData(this.categoryService);
    public product = new ProductData(this.productService);

    ngOnInit(): void {
        this.category.ngOnInit();
        this.product.ngOnInit();
        this.contentArray = this.contentArray.map((v: string, i: number) => `Content line ${i + 1}`);
        this.returnedArray = this.contentArray.slice(0, 10);
    }

    pageChanged(event: PageChangedEvent): void {
        const startItem = (event.page - 1) * event.itemsPerPage;
        const endItem = event.page * event.itemsPerPage;
        this.returnedArray = this.contentArray.slice(startItem, endItem);
    }

    constructor( private categoryService: CategoryService, private productService: ProductService ) {}

    ngOnDestroy(): void {
    }
}
