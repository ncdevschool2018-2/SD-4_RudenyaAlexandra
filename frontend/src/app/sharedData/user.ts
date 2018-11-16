import { OnInit, OnDestroy } from '@angular/core';
import {User} from '../model/user';
import { UserService } from '../service/user.service';
import { Subscription } from 'rxjs/internal/Subscription';

export class UserData implements OnInit, OnDestroy {

  passwordRepeat: string;
  public editMode = false;
  public editUser =  new User();
  public userAccount: User[];

  private subscriptions: Subscription[] = [];

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.loadUser();
  }


  public _addUser(): void {
      this.editUser.role = 'user';
      this.subscriptions.push(this.userService.saveUser
        (this.editUser).subscribe(() => {
            this._updateUser();
            this.refreshUser();
        }));
  }

  public _updateUser(): void {
      this.loadUser();
  }

  public refreshUser(): void {
      this.editUser = new User();
  }

  public _deleteUser(userId: string): void {
    this.subscriptions.push(this.userService.deleteUser(userId).subscribe(() => {
      this._updateUser();
      this.refreshUser();
    }));
  }

  private loadUser(): void {
    // Get data from BillingAccountService
    this.subscriptions.push(this.userService.getUser().subscribe(accounts => {
      // Parse json response into local array
      this.userAccount = accounts as User[];
      // Check data in console
      console.log(this.userAccount); // don't use console.log in angular :)
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription =>
      subscription.unsubscribe());
  }
}
