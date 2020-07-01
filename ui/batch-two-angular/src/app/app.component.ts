import { Component, VERSION } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


      message = "Welcome to Angular world!";
      names:string[] = ["Krish","Manoj","Ramana","Hari"];
      imgUrl = "https://angular.io/assets/images/logos/angular/logo-nav@2x.png";

      searchStr = "";

      constructor(){
        setTimeout(() => {
          this.searchStr = "Krish";
        }, 3000);
      }
      showMoreDetails(name:string){
          console.log("More details method yet to implement....."+name);
      }


      contacts = [
        {"name":"Krish","email":"krish.t@gmail.com","mobile":"8765456789"},
        {"name":"Manoj","email":"manoj.t@gmail.com","mobile":"8765456788"},
        {"name":"Suresh","email":"suresh.t@gmail.com","mobile":"8765456787"},
        {"name":"Jayesh","email":"jayesh.t@gmail.com","mobile":"8765456786"}
      ]

}
