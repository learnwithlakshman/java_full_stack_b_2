import { Player, RoleCount } from './../model/team.model';
import { IplService } from './../ipl.service';
import { Component, OnInit } from '@angular/core';
import { GoogleChartInterface, ChartSelectEvent } from 'ng2-google-charts';

@Component({
  selector: 'app-stat',
  templateUrl: './stat.component.html',
  styleUrls: ['./stat.component.css']
})
export class StatComponent implements OnInit{

    labels:String[];
    selectedTeam:string;
    players:Player[] = [];
    playerByRole:Player[]=[];

    constructor(private service:IplService){

    }

    ngOnInit(){
      this.service.getAllLabels().subscribe(res=>{
          this.labels = res.labels;
      })
    }
    getSelectedTeamPlayers(event:any){
        this.selectedTeam = event.target.value;

        if(this.selectedTeam.length!=0){
            this.getPlayerDetails(this.selectedTeam);
            this.getPlayerCountOfAllRoles(this.selectedTeam);
        }
    }
    getPlayerCountOfAllRoles(selectedTeam: string) {
       this.service.getPlayerCountOfAllRoles(selectedTeam).subscribe(res=>{
          let data:any = [["Role","Count"]]
          let roleCount:RoleCount[] = res;
          for(let r of roleCount){
              data.push([r.roleName,r.count]);
          }
          this.drawCountChart(data);
       })
  }

    getPlayerDetails(teamLabel:string){
        this.service.getPlayerDetails(teamLabel).subscribe(res=>{
            this.players = res;
        })
    }
    public pieChart: GoogleChartInterface;
    drawCountChart(data:any){
      console.log(data);
      this.pieChart= {
        chartType: 'PieChart',
        dataTable: data,
        //firstRowIsData: true,
        options: { width: 800,
          height: 400,
          title: `${this.selectedTeam} Role count details`,
        }
      };
    }


    select(event:ChartSelectEvent){
      let role = event.selectedRowFormattedValues[0];
      this.service.getPlayerByTeamAndRole(this.selectedTeam,role).subscribe(res=>{
              this.playerByRole = res;
      })
    }


}
