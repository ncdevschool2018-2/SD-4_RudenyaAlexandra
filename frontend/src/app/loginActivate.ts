import { Injectable } from '@angular/core';
import { AuthService } from './service/auth.service';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { CanActivate } from '@angular/router/src/utils/preactivation';
import { TokenStorage } from './core/token.srorage';
import { Location } from '@angular/common';

@Injectable()
export class LoginActivate implements CanActivate {
    path: ActivatedRouteSnapshot[];
    route: ActivatedRouteSnapshot;

    constructor(private authService: AuthService, private router: Router, private tokenStorage: TokenStorage,
        private location: Location) {}

    canActivate(route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean>|Promise<boolean>|boolean {
            if (this.tokenStorage.getToken() !== null) {
              this.router.navigateByUrl('/home');
              return false;
            }
            return true;
    }
}
