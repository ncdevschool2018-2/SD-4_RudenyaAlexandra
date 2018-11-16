import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserData } from '../sharedData/user';
import { UserService } from '../service/user.service';
import { Subscription } from 'rxjs';

@Component({
    selector: 'app-signin-page',
    templateUrl: './signin-page.component.html',
    styleUrls: ['./signin-page.component.css']
})

export class SigninComponent implements OnInit, OnDestroy {

  public v: true;
  passwordRepeat: string;
  public user = new UserData(this.userService);
  public subscription: Subscription[] = [];

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.user.ngOnInit();
  }

  ngOnDestroy(): void {
  }
}
 // указать все поля для 2 сущносте1, отправляю модельку user и account saveUser , filter java, spring ses, val - fapi, 
// констуроктор объявить на бэке и тянуть только определенные
