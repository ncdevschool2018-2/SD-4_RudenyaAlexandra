import { Component, OnDestroy, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { ProductData } from '../sharedData/product';
import { CommentService } from '../service/comment.service';
import { CommentData } from 'src/app/sharedData/comment';
import { AccountService } from '../service/account.service';
import { AccountData } from '../sharedData/account';
import { PageChangedEvent } from 'ngx-bootstrap/pagination/public_api';

@Component ({
    selector: 'app-product',
    templateUrl: './product.component.html',
    styleUrls: ['./product.component.css']
})

export class ProductComponent implements OnInit, OnDestroy {

    public id: number;
    public comment = new CommentData(this.commentService);
    public product = new ProductData(this.productService) ;
    constructor(private productService: ProductService, private commentService: CommentService,
        private accountService: AccountService) {}

    ngOnInit() {
        this.product.ngOnInit();
        this.comment.ngOnInit();
        this.product._getProductById(1);
    }

    ngOnDestroy() {}

}

