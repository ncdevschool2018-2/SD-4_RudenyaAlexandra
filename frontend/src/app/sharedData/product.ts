import { OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { Category } from '../model/category';
import { Comment } from '../model/comment';
import { Page } from '../model/page';


export class ProductData implements OnInit, OnDestroy {

    editProduct: Product = new Product();
    productMas: Product[] = [];
    productById:  Product;
    private subscription: Subscription[] = [];
    productByCategoryId: Product[];
    isLoad = false;
    constructor(private productService: ProductService, private loading: Ng4LoadingSpinnerService) {}

    ngOnInit() {
        this._loadProduct(); }


    _loadProduct() {
        this.loading.show();
        this.subscription.push(this.productService.getProduct().subscribe( product => {
            this.productMas = product;
            this.editProduct.category = new Category();
            this.editProduct.comment = new Comment();
            this.isLoad = true;
            this.loading.hide();
        }));
    }

    _loadProductByCategoryId(id: number) {
        this.loading.show();
        this.subscription.push(this.productService.getProductByCategoryId(id).subscribe( product => {
            this.productByCategoryId = product;
            this.isLoad = true;
            this.loading.hide();
        }));
    }

    _updateProduct() {
        this._loadProduct();
    }

    _refreshProduct() {
        this.editProduct = new Product();
    }

     _deleteProduct(product_id: number) {
        this.subscription.push(this.productService.deleteProduct(product_id).subscribe( () => {
            this._updateProduct();
            this._refreshProduct();
        }));
    }

    _addProduct() {
        this.loading.show();
        this.subscription.push(this.productService.saveProduct(this.editProduct).subscribe( () => {
            this._updateProduct();
            this._refreshProduct();
            this.loading.hide();
        }));
    }

     _getProductById(id: number) {
        this.loading.show();
        this.subscription.push(this.productService.getProductById(id).subscribe( product => {
            this.productById = product as Product;
            this.isLoad = true;
            this.loading.hide();
        }));
    }
    ngOnDestroy(): void {
        this.subscription.forEach(subscription => subscription.unsubscribe());
      }
}

