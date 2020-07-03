import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IplRoutingModule } from './ipl-routing.module';
import { IplComponent } from './ipl.component';
import { TeamsComponent } from './teams/teams.component';
import { PlayersComponent } from './players/players.component';
import { HomeComponent } from './home/home.component';
import { StatComponent } from './stat/stat.component';



@NgModule({
  declarations: [IplComponent, TeamsComponent, PlayersComponent, HomeComponent, StatComponent],
  imports: [
    CommonModule,
    IplRoutingModule,
    FormsModule

  ]
})
export class IplModule { }
