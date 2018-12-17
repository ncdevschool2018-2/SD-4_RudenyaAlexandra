import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  name = '';
  constructor(private auth: AuthService) { }

  ngOnInit() {
  }

  getName() {
    this.name = this.auth.getUsername();
  }

}
