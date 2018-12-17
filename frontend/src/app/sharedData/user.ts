import { OnInit, OnDestroy, Input } from '@angular/core';
import {User} from '../model/user';
import { UserService } from '../service/user.service';
import { Subscription } from 'rxjs/internal/Subscription';
import { Account } from '../model/account';
import { Role } from '../model/role';
import { AuthService } from '../service/auth.service';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

export class UserData implements OnInit, OnDestroy {

  passwordRepeat: string;
  editMode = false;
  editUser =  new User();
  userAccount: User[];
  userByLogin = new User();
  isLoad = false;

  private subscriptions: Subscription[] = [];

  constructor(private userService: UserService,
    private loadingService: Ng4LoadingSpinnerService) {
  }

  ngOnInit() {
    this._loadUser();
    this.editUser.account = new Account();
    this.editUser.role = new Role();
  }


  _addUser(): void {
      this.subscriptions.push(this.userService.saveUser
        (this.editUser).subscribe(() => {
            this._updateUser();
            this.refreshUser();
            this.loadingService.hide();
    }));
  }

   _updateUser(): void {
      this._loadUser();
  }

  refreshUser(): void {
      this.editUser = new User();
  }

   _deleteUser(userId: string): void {
    this.subscriptions.push(this.userService.deleteUser(userId).subscribe(() => {
      this._updateUser();
      this.refreshUser();
    }));
  }

  _loadUser(): void {
    // Get data from BillingAccountService
    this.subscriptions.push(this.userService.getUser().subscribe(users => {
      this.userAccount = users;
      this.isLoad = true;
      this.loadingService.hide();
    }));
  }

   _getUserByLogin(login: string) {
    this.subscriptions.push(this.userService.getUserByLogin(login).subscribe( user => {
        this.userByLogin = user;
        this.isLoad = true;
        this.loadingService.hide();
    }));
  }

  userIdByLogin(login: string): number {
    return this.userByLogin.userId;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription =>
      subscription.unsubscribe());
  }
}
