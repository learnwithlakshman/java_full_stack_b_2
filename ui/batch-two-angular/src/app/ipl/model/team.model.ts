export interface Team{
    label:string;
    team:string;
    city:string;
    coach:string;
    home:string;
    players:Player[];
}
export interface Player{
  player:string;
  price:number;
  role:string;
}

export interface RoleCount{
    name:string;
    count:number;
}
