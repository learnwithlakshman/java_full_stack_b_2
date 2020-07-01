import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  username:string;
  users:string[]=[];
  constructor() { }

  ngOnInit(): void {
  }

  addUser(){
    if(this.username && this.username.length > 0){
        this.users.push(this.username);
        this.username="";
    }
  }

}
