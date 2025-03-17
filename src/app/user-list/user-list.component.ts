import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import {UserService} from "../user-service.service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit {
  users?: User[];
  constructor(private userService: UserService) {
  }
  ngOnInit(){
    this.userService.findAll().subscribe(data => {this.users = data;});
}

}
