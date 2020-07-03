import { IplModule } from './ipl/ipl.module';
import { NotfoundComponent } from './notfound/notfound.component';
import { UserComponent } from './user/user.component';
import { QuizComponent } from './quiz/quiz.component';
import { IplComponent } from './ipl/ipl.component';
import { BasicsComponent } from './basics/basics.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
      {
        path:'',
        component:BasicsComponent,
        pathMatch:'full'
      },
      {
        path:'basics',
        component:BasicsComponent
      },
      {
        path:'ipl',
        loadChildren: ()=>import('./ipl/ipl.module').then(m=>m.IplModule)
      },{
        path:'quiz',
        component:QuizComponent
      },
      {
        path:'user',
        component:UserComponent
      },
      {
        path:"**",
        component:NotfoundComponent
      }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
