import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  imgUrl = "https://getbootstrap.com/docs/4.5/assets/brand/bootstrap-solid.svg";
  constructor() { }

  ngOnInit(): void {
  }

}
