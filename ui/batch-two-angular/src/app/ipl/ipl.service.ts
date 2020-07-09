import { environment } from './../../environments/environment';
import { Team, Player, RoleCount, TeamLabels } from './model/team.model';
import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class IplService{

      base_url = environment.base_url;

      constructor(private http:HttpClient){

      }

      getAllLabels():Observable<TeamLabels>{
        return this.http.get<TeamLabels>(`${this.base_url}labels`);
      }

      getPlayerDetails(teamLabel:string):Observable<Player[]>{
        return this.http.get<Player[]>(`${this.base_url}${teamLabel}`);
      }

      getPlayerCountOfAllRoles(teamLabel:string):Observable<RoleCount[]>{
        return this.http.get<RoleCount[]>(`${this.base_url}role/${teamLabel}`);
      }

      getPlayerByTeamAndRole(teamLabel:string,role:string):Observable<Player[]>{
        return this.http.get<Player[]>(`${this.base_url}${teamLabel}/${role}`);
      }
}
