import { Component, OnInit, Injectable } from '@angular/core';
import { UserService } from '../service/user.service';
import { UserData } from '../sharedData/user';
import { LoginUser } from '../model/loginUser';
import { AuthService } from '../service/auth.service';
import { TokenStorage } from '../core/token.srorage';
import { AppRoutingModule } from '../app-routing.module';
import { Router } from '@angular/router';
import { Token } from '../model/token';
import { JwtDecode } from '../model/jwtDecode';


@Component({
    selector: 'app-login-page',
    templateUrl: './login-page.component.html',
    styleUrls: ['./login-page.component.css']
})

export class LoginComponent implements OnInit {

  isActive = false;
  loginUser: LoginUser = new LoginUser();
  role: string;
  public userD: JwtDecode;
  public user = new UserData(this.userService);
  constructor(private userService: UserService, private authService:
    AuthService, private tokenStorage: TokenStorage, private router: Router) {}

  ngOnInit() {
    this.user.ngOnInit();
  }

 public getToken(): void {
    this.authService.attempAuth(this.loginUser).subscribe ( authToken => {
      // tslint:disable-next-line:prefer-const
      let token: Token = authToken as Token;
      this.tokenStorage.saveToken(token.token);
      this.userD = this.authService.decodeJwt(token.token);
    });

  }
  public login() {
    if (this.tokenStorage.getToken() !== null) {
      this.router.navigateByUrl('/account');
      window.location.reload();
    }
  }

}
