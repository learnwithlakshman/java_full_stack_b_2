import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-basics',
  templateUrl: './basics.component.html',
  styleUrls: ['./basics.component.css']
})
export class BasicsComponent implements OnInit {

  imgPath = "../assets/img/databinding.png";
  users:string[] ="Krish,Manoj,Rajesh,Ramith,Ramya".split(",");
  view:string;
  searchStr:string;
  imgUrl:string = "../assets/img/on.PNG";
  flag = 1;
  constructor() { }

  ngOnInit(): void {
  }

  changeStatus(){
      if(this.flag == 1){
        this.imgUrl= "../assets/img/off.PNG";
        this.flag = 0;
      }else{
        this.flag = 1;
        this.imgUrl= "../assets/img/on.PNG";
      }
  }

}
