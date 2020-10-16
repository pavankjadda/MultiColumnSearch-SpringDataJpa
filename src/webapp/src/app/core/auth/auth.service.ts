import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from "@angular/core";
import {CookieService} from "ngx-cookie-service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {User} from "src/app/core/model/user";

@Injectable({
  providedIn: "root",
})
export class AuthService
{
  redirectUrl: string;
  public currentUser: Observable<User>;

  constructor(
    private httpClient: HttpClient,
    private cookieService: CookieService
  )
  {
  }

  public get currentUserValue(): User
  {
    return JSON.parse(this.cookieService.get("currentUser"));
  }

  isUserLoggedIn(): boolean
  {
    return this.cookieService.get("isLoggedIn") === "true";
  }


  login(url: string, formData: FormData)
  {
    return this.httpClient.post<User>(url, formData)
               .pipe(
                 map((user) =>
                 {
                   // login successful if there's a Spring Session token in the response
                   if (user && user.token)
                   {
                     // store user details and Spring Session token as cookies
                     this.cookieService.set("currentUser", JSON.stringify(user));
                     this.cookieService.set("jwtToken", user.token);
                     this.cookieService.set("isLoggedIn", "true");
                   }
                   return user;
                 })
               );
  }

  logout()
  {
    this.cookieService.deleteAll();
  }
}
