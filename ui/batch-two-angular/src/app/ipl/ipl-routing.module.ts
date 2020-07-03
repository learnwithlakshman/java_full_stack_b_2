import { StatComponent } from './stat/stat.component';
import { HomeComponent } from './home/home.component';
import { PlayersComponent } from './players/players.component';
import { TeamsComponent } from './teams/teams.component';
import { IplComponent } from './ipl.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [


      {
        path:'',
        component:IplComponent,
        children:[
         {
            path:'teams',
            component:TeamsComponent
          },{
            path:'players',
            component:PlayersComponent
          },{
            path:'stat',
            component:StatComponent
          }
        ]
      }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class IplRoutingModule { }
