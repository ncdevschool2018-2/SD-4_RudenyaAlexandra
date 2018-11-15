import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { ValidUser } from './validUser';
import { UserData } from '../sharedData/user';


@Component({
    selector: 'app-login-page',
    templateUrl: './login-page.component.html',
    styleUrls: ['./login-page.component.css']
})

export class LoginComponent implements OnInit {

  remember = false;
  public user = new UserData(this.userService);
  constructor(private userService: UserService) {}

  ngOnInit() {
    this.user.ngOnInit();
  }
}
