import { Injectable } from '@angular/core';
import { AuthService } from './service/auth.service';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { CanActivate } from '@angular/router/src/utils/preactivation';
import { TokenStorage } from './core/token.srorage';

@Injectable()
export class LoginActivate implements CanActivate {
    path: ActivatedRouteSnapshot[];
    route: ActivatedRouteSnapshot;

    constructor(private authService: AuthService, private router: Router, private tokenStorage: TokenStorage) {}

    canActivate(route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean>|Promise<boolean>|boolean {
            if (this.tokenStorage.getToken() !== null) {
              return false;
            }
            return true;
    }
}
