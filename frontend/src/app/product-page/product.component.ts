import { Component, OnDestroy, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { ProductData } from '../sharedData/product';
import { CommentService } from '../service/comment.service';
import { CommentData } from 'src/app/sharedData/comment';
import { UserService } from '../service/user.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { AuthService } from '../service/auth.service';
import { SubscribeService } from '../service/subscribe.service';
import { SubscribeData } from '../sharedData/subscription';
import * as moment from 'moment';
import { Account } from '../model/account';
import { User } from '../model/user';
import { UserData } from '../sharedData/user';
import { Role } from '../model/role';
import { Subscription } from 'rxjs';
import { Product } from '../model/product';
import { TokenStorage } from '../core/token.srorage';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component ({
    selector: 'app-product',
    templateUrl: './product.component.html',
    styleUrls: ['./product.component.css']
})

export class ProductComponent implements OnInit, OnDestroy {

    idProduct: number;
    userLogin: User;
    comment = new CommentData(this.commentService);
    product = new ProductData(this.productService, this.loadingSpinnerService) ;
    subscribes = new SubscribeData(this.subscribeService, this.loadingSpinnerService);
    user  = new UserData(this.userService, this.loadingSpinnerService);
    private subscription: Subscription[] = [];
    constructor(private location: Location, private productService: ProductService, private commentService: CommentService,
    private userService: UserService, private  loadingSpinnerService: Ng4LoadingSpinnerService,
    // tslint:disable-next-line:max-line-length
    private router: ActivatedRoute, private auth: AuthService, private subscribeService: SubscribeService, private token: TokenStorage) {
    }

    ngOnInit() {
        this.product.ngOnInit();
        this.comment.ngOnInit();
        this.router.params.subscribe(params => {
            this.idProduct = params.id;
        });
        this.user.editUser.account = new Account();
        this.user.editUser.role = new Role();
        if (this.token.getToken() !== null) {
            this.user._getUserByLogin(this.auth.getUsername());
        }
    }

    goBack() {
        if (window.history.length > 1) {
            this.location.back();
        }
    }

    subscribe(): void {
        this.subscribes.editSubscribe.startDate = moment().format('YYYY-MM-DD').toString();
        this.subscribes.editSubscribe.endDate = moment(this.subscribes.editSubscribe.startDate).add(30, 'day').format('YYYY-MM-DD');
        this.subscribes.editSubscribe.account.accountId =  this.user.userByLogin.userId;
        this.subscribes.editSubscribe.product.productId =  this.product.productMas[this.idProduct].productId;
        this.subscribes.editSubscribe.status = true;
        this.subscribes._addSubscribe();
    }

    disabled(): boolean {
        let d = true;
        if (this.token.getToken() !== null) {
            d =  false;
        }
        return d;
    }

    ngOnDestroy() {}

}

