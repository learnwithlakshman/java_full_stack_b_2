import { IplService } from './../ipl.service';
import { Team } from './../model/team.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  teams:Team[] = [];

  constructor(private iplService:IplService) {

      console.log(this.iplService.getTeamLabels());

   }

  ngOnInit(): void {
  }
  submit(f:any){
     let team:Team = f.value;
     this.teams.push(team);
     console.log(this.teams);
  }

}
