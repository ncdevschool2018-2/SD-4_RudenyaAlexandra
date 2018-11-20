import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserData } from '../sharedData/user';
import { UserService } from '../service/user.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { TokenStorage } from '../core/token.srorage';
import { LoginUser } from '../model/loginUser';

@Component({
    selector: 'app-signin-page',
    templateUrl: './signin-page.component.html',
    styleUrls: ['./signin-page.component.css']
})

export class SigninComponent implements OnInit, OnDestroy {
//спросить про loginUser нужен ли ?
  public v: true;
  passwordRepeat: string;
  public user = new UserData(this.userService);
  public loginUser: LoginUser = new LoginUser();
  public subscription: Subscription[] = [];

  constructor(private userService: UserService, private router: Router,
    private authService: AuthService, private token: TokenStorage) {}

  ngOnInit() {
    this.user.ngOnInit();
  }

  login(): void {
    this.authService.attempAuth(this.user.editUser.login,
       this.user.editUser.password).subscribe(
         data => {
           this.token.saveToken(data.token);
           localStorage.setItem('currentUser', this.loginUser.login);
           this.userService.getUser().subscribe(user => {
             localStorage.setItem('currentRole', this.user.userAccount.role);
           });
         }
       );
  }
  ngOnDestroy(): void {
  }
}

