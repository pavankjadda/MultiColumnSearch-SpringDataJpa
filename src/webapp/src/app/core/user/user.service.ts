import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';

@Injectable({
    providedIn: 'root'
})
export class UserService
{
  constructor(
      private httpClient: HttpClient,
      private cookieService: CookieService
  ) {}


  getUserInformation(url: string)
  {
    return this.httpClient.get(url);
  }
}
