import {Authority} from 'src/app/core/model/authority';

export class User {
  id: number;
  username: string;
  authorities: Authority[];
  token: string;
}
