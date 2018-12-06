import {Injectable} from '@angular/core';
import {HttpErrorResponse, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import {TokenStorage} from './token.srorage';
import {tap} from 'rxjs/operators';
import {HttpEvent} from '@angular/common/http/src/response';

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class Interceptor implements HttpInterceptor {

  constructor(private token: TokenStorage, private router: Router) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("Interceptor works");
    let authReq = req;
    if (this.token.getToken() !== null) {
      authReq = req.clone({headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this.token.getToken())});
    }

    return next.handle(authReq).pipe(tap((event: HttpEvent<any>) => {
        if (event instanceof HttpResponse) {
          console.log("Interceptor log response", event);
        }
      }, (err: any) => {
        if (err instanceof HttpErrorResponse) {
          if (err.status === 401) {
            this.router.navigateByUrl('/login');
            alert('Вы ввели неверные данные попробуйте еще');
          }
        }
      }
    ));
  }

}
