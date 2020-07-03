import { Player, RoleCount } from './../model/team.model';
import { IplService } from './../ipl.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stat',
  templateUrl: './stat.component.html',
  styleUrls: ['./stat.component.css']
})
export class StatComponent implements OnInit {

  labels:string[] = [];
  selectedTeamLabel:string;
  players:Player[] = [];
  roleCount:RoleCount[];
  constructor(private iplService:IplService) { }

  ngOnInit(): void {
    this.labels = this.iplService.getTeamLabels();
  }

  getPlayerDetails(){
      if(this.selectedTeamLabel && this.selectedTeamLabel.length > 0){
        this.players = this.iplService.getPlayers(this.selectedTeamLabel);
        this.roleCount = this.iplService.getRoleCount(this.selectedTeamLabel);
      }

  }

}
