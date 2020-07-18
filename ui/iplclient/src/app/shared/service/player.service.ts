import { RoleCount } from './../models/rolecount.model';
import { Player } from './../models/player.model';
import { LabelInfo } from './../models/labelinfo.model';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {


  baseUrl = environment.baseurl;

  constructor(private http:HttpClient) {
  }

  fetchTeamLabels():Observable<LabelInfo>{
      return this.http.get<LabelInfo>(`${this.baseUrl}/labels`);
  }

  fetchPlayerByTeams(team:string):Observable<Player[]>{
     return this.http.get<Player[]>(`${this.baseUrl}/players/${team}`);
  }

  fetchRoleCountByTeams(team: string):Observable<RoleCount[]> {
     return this.http.get<RoleCount[]>(`${this.baseUrl}/rolecount/${team}`);
  }



}
