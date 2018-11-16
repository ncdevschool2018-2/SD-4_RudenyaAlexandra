import { OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

export class ProductData implements OnInit, OnDestroy {

    public editProduct: Product = new Product();
    public products: Product[];
    public productById:  Product;
    public subscription: Subscription[] = [];

    constructor(private productService: ProductService) {}

    ngOnInit() { this._loadProduct(); }
    ngOnDestroy() {}

    private _loadProduct() {
        this.subscription.push(this.productService.getProduct().subscribe( product => {
            this.products = product as Product[];
            console.log(product);
        }));
    }

    public _updateProduct() {
        this._loadProduct();
    }

    public _refreshProduct() {
        this.editProduct = new Product();
    }

    public _deleteProduct(product_id: number) {
        this.subscription.push(this.productService.deleteProduct(product_id).subscribe( () => {
            this._updateProduct();
            this._refreshProduct();
        }));
    }

    public _addProduct() {
        this.subscription.push(this.productService.saveProduct(this.editProduct).subscribe( () => {
            this._updateProduct();
            this._refreshProduct();
        }));
    }

    public _getProductById(id: number) {
        this.subscription.push(this.productService.getProductById(id).subscribe( product => {
            this.productById = product as Product;
        }));
    }
}

