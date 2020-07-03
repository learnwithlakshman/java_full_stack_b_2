import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  username: string;
  users: string[] = [];
  flag = false;
  editName: string;
  constructor() {}

  ngOnInit(): void {}

  addUser() {
    if (this.flag) {
      let index = this.indexOfEditName();
      if(index != -1){
          this.users[index] = this.username;
          this.flag = false;
        }
      } else {
        if (this.username && this.username.length > 0) {
          this.users.push(this.username);

        }
      }
    this.username = ''
    this.editName = ''
  }
  editUser(user: string) {
    this.editName = user;
    this.username = user;
    this.flag = true;
  }
  deleteUser(user: string) {
     let res = confirm("Are you sure do you want delete "+user+"?");
     if(res){
     this.editName = user;
      let index = this.indexOfEditName();
      if(index!=-1){
        this.users.splice(index,1);
      }
      this.editName = '';
    }
  }

  indexOfEditName(){
      for(let i=0;i<this.users.length;i++){
        if(this.users[i] === this.editName)
            return i;
      }
      return -1;
  }

}
