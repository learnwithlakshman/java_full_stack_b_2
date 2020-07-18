import { RoleCount } from './../shared/models/rolecount.model';
import { Player } from './../shared/models/player.model';
import { PlayerService } from './../shared/service/player.service';
import { Component, OnInit } from '@angular/core';
import { GoogleChartInterface } from 'ng2-google-charts';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit {

  labels:string[];
  selectedTeam:string;
  players:Player[];
  roleCount:RoleCount[];
  pieChartData:any;

  constructor(private playerService:PlayerService) { }

  ngOnInit(): void {
      this.playerService.fetchTeamLabels().subscribe(res=>{
          this.labels = res.labels;
      })
  }
  playerDetails(teamName:string){
     if(teamName.length != 0){
          this.selectedTeam = teamName;
          this.playerService.fetchPlayerByTeams(this.selectedTeam).subscribe(res=>{
              this.players = res;
          })

          this.playerService.fetchRoleCountByTeams(this.selectedTeam).subscribe(res=>{
            this.roleCount = res;
            this.pieChartData = [["Rolename","Count"]];
            for(let r of this.roleCount){
                this.pieChartData.push([r.roleName,r.count]);
            }
            this.drawPieChart();
        })

      }
  }

  public pieChart: GoogleChartInterface = {
    chartType: 'PieChart',
    dataTable:this.pieChartData,
    options: {'title': 'Tasks','width':600,'height':400},
  };

  drawPieChart(){
     this.pieChart.dataTable = this.pieChartData;
     let cchart = this.pieChart.component;
     let ccWrapper = cchart.wrapper;
     cchart.wrapper.setDataTable(this.pieChart.dataTable);
     cchart.draw();
    }


}
