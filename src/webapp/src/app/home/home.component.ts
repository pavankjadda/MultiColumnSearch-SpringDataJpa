import {Component, OnInit} from "@angular/core";
import {map} from 'rxjs/operators';
import {environment} from '../../environments/environment';
import {USER_API_URL} from '../constants/app.constants';
import {AuthService} from '../core/auth/auth.service';
import {User} from '../core/model/user';
import {UserService} from '../core/user/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public authService:AuthService, private userService:UserService) { }

  ngOnInit(): void
  {
    this.getUserInformation();
  }

  private getUserInformation()
  {
    const url = environment.BASE_URL + USER_API_URL + '/home';

    return this.userService.getUserInformation(url)
        .subscribe(data =>
        {

        });
  }
}
