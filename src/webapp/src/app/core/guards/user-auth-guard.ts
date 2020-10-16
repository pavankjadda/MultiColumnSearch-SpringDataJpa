import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot,} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';
import {AuthService} from 'src/app/core/auth/auth.service';

@Injectable({
    providedIn: 'root',
})
export class UserAuthGuard implements CanActivate
{
    constructor(
        private authService: AuthService,
        private router: Router,
        private cookieService: CookieService
    )
    {
    }

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): boolean
    {
        const url: string = state.url;
        return this.checkLogin(url);
    }

    hasUserRole()
    {
      return JSON.parse(this.cookieService.get('currentUser'))?.authorities?.find(authority => authority.authority === 'ROLE_USER')!==undefined;
    }

    private checkLogin(url: string): boolean
    {
        if (this.authService.isUserLoggedIn() && this.hasUserRole())
        {
            return true;
        }

        // Store the attempted URL for redirecting
        this.authService.redirectUrl = url;

        // Navigate to the login page with extras
        this.router.navigate(['/login']);
        return false;
    }
}
