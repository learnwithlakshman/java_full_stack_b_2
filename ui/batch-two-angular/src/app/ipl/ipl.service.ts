import { Team, Player, RoleCount } from './model/team.model';
import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class IplService implements OnInit {



  teams:Team[] = [];
  constructor(private http:HttpClient) {
    this.http.get<Team[]>("../../assets/seeddata/ipl2020.json").subscribe(res=>{
      this.teams = res;
    })
  }
  ngOnInit(): void {

  }

  getTeamLabels():string[]{
      if(this.teams.length == 0){
         this.http.get<Team[]>("../../assets/seeddata/ipl2020.json").subscribe(res=>{
          this.teams = res;
          let labels =  this.teams.map(e=>e.label);

          return labels;
        })
      }else{
        return this.teams.map(e=>e.label);
      }

  }

  getPlayers(selectedTeamLabel: string):Player[] {
    if(this.teams.length == 0){
      this.http.get<Team[]>("../../assets/seeddata/ipl2020.json").subscribe(res=>{
       this.teams = res;
        return this.teams.filter(e=>e.label===selectedTeamLabel)[0].players;

     })
   }else{
     return  this.teams.filter(e=>e.label===selectedTeamLabel)[0].players;
   }

  }

  getRoleCount(selectedTeamLabel: string):RoleCount[] {
    let players:Player[];
    if(this.teams.length == 0){
      this.http.get<Team[]>("../../assets/seeddata/ipl2020.json").subscribe(res=>{
       this.teams = res;
        players =  this.teams.filter(e=>e.label===selectedTeamLabel)[0].players;

     })
   }else{
       players = this.teams.filter(e=>e.label===selectedTeamLabel)[0].players;
   }
  let rc:RoleCount[] = [];
  let map = new Map();
  for(let player of players)
  {
      if(map[player.role]){

      }else{

      }
  }
  //Collection k,v => put inside rc array

  return rc;


  }


}
