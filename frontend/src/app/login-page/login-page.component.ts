import { Component, OnInit } from '@angular/core';
import {User} from '../model/user';
import { UserService } from '../service/user.service';
import { Subscription } from 'rxjs/internal/Subscription';
import { ValidUser } from './validUser';


@Component({
    selector: 'app-login-page',
    templateUrl: './login-page.component.html',
    styleUrls: ['./login-page.component.css']
})

export class LoginComponent implements OnInit {

  remember = false;
  public editMode = false;
  public userAccount: User[];
  public userValidate: ValidUser[] ;

  private subscriptions: Subscription[] = [];
  public editTableUser: ValidUser = new ValidUser();

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.loadUser();
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

}
