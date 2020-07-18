import { TeamsComponent } from './teams/teams.component';
import { PlayersComponent } from './players/players.component';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [

    {
      path:'',
      component:HomeComponent,
      pathMatch:'full'
    },
    {
      path:'home',
      component:HomeComponent
    },{
      path:'players',
      component:PlayersComponent
    },{
      path:'teams',
      component:TeamsComponent
    }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
