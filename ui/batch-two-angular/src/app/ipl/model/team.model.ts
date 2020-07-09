export interface Team{
    label:string;
    team:string;
    city:string;
    coach:string;
    home:string;
    players:Player[];
}
export interface Player{
  label:string;
  name:string;
  price:number;
  role:string;
}
export interface RoleCount{
    roleName:string;
    count:number;
}
export interface TeamLabels{
    labels:string[];
}
