import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest,} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {CookieService} from "ngx-cookie-service";
import {Observable} from "rxjs";
import {AuthService} from "../auth/auth.service";

@Injectable()
export class HttpTokenInterceptor implements HttpInterceptor {
  constructor(
    private authService: AuthService,
    private cookieService: CookieService
  ) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    let jwtToken = this.cookieService.get("jwtToken");
    if (jwtToken) {
      request = request.clone({
        setHeaders: {
          "Authorization": 'Bearer '+jwtToken,
        },
      });
    }
    return next.handle(request);
  }
}
