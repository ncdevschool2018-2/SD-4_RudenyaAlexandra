import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Comment } from '../../model/comment';
import { CommentService } from '../../service/comment.service';
import { Product } from '../../model/product';
import { ProductService } from '../../service/product.service';
import { CommentData } from '../../sharedData/comment';
import { ProductData } from 'src/app/sharedData/product';
@Component({
    selector: 'app-comment-user',
    templateUrl: 'commentUser.component.html',
    styleUrls: ['commentUser.component.css']
})

export class CommentUserComponent implements OnInit, OnDestroy {

    public comments = new CommentData(this.commentService);
    public products = new ProductData(this.productService);

    public editProduct: Product = new Product();
    public subscription1: Subscription[] = [];
    constructor(private commentService: CommentService, private productService: ProductService) {}

    ngOnDestroy(): void {
    }
    ngOnInit() {
        this.comments._loadComment();
    }
}
