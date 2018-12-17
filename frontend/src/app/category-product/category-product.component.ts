import { Component, OnDestroy, OnInit, Output, EventEmitter } from '@angular/core';
import { CategoryData } from '../sharedData/category';
import { CategoryService } from '../service/category.service';
import { ProductData } from '../sharedData/product';
import { ProductService } from '../service/product.service';
import { PageChangedEvent } from 'ngx-bootstrap/pagination';
import { Product } from '../model/product';
import { Router } from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { Page } from '../model/page';
import { PageData } from '../sharedData/page';
import { PageService } from '../service/page';

@Component ({
    selector: 'app-category-product',
    templateUrl: './category-product.component.html',
    styleUrls: ['./category-product.component.css']
})

export class CategoryProductComponent implements OnInit, OnDestroy {

    returnedArray: Product[];
    category = new CategoryData(this.categoryService);
    product = new ProductData(this.productService, this.loading);
    pageProduct = new PageData<Product>(this.pageService, this.loading );
    name = 'product';
    ngOnInit(): void {
        this.loading.show();
        this.pageProduct.getPageContent('product', 0, 4);
        console.log();
        this.category.ngOnInit();
        this.product.ngOnInit();
    }

    constructor(private pageService: PageService,
        private router: Router, private categoryService: CategoryService,
        private productService: ProductService, private loading: Ng4LoadingSpinnerService) {}

    ngOnDestroy(): void {
    }

    getId(id: number): void {
        let p: number;
        for ( p = 0 ; p < this.product.productMas.length.valueOf(); p++) {
            // tslint:disable-next-line:triple-equals
            if (this.product.productMas[p].productId == id ) {
                this.router.navigate([`/product/${p}`]);
            }
        }
    }

    pageChanged(event: PageChangedEvent): void {
        const startItem = (event.page) * event.itemsPerPage;
        const endItem = event.page * event.itemsPerPage;
        this.pageProduct.getPageContent(this.name, startItem, 4);
       // this.returnedArray = this.pageProduct.pageContent.content;
    }
}
