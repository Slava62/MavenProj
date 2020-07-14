package ru.geekbrains.java.oop.at;

import java.util.ArrayList;
import java.util.Arrays;
// Создает команду участников типа Sportsman (Human, Cat, Robot)
public class Team {
   private  String [] arr;
   private ArrayList<Sportsman> team;
   private String teamname;
   private IOutputProvider outputProvider;
    Team(String teamname){
        this.team=new ArrayList<Sportsman>();
        this.teamname=teamname;
        outputProvider=new DesktopFormOutputProvider(teamname);
    }
    // Добавляем участника в команду
    public void addSportsmam(Sportsman sportsman){
        team.add(sportsman);
    }
    // Информация о команде
    public void getTeamInfo(){
        arr = new String[team.size()];
        for (int i=0;i<arr.length;i++){
            arr[i]=team.get(i).getInfo();
        }
        //console output
        outputProvider.print( "The team " + teamname + " consists of: " + Arrays.toString(arr));
    }
    // Запуск прохождения командой полосы препятствий
    public void startCompetition(ArrayList<Obstacle> course){
        //console output
        outputProvider.print("Competition start!");
        for (Obstacle obstacle:course) {
            for (int i = 0; i < arr.length; i++) {
                if (team.get(i).getCondition())
                //console output
                outputProvider.print(team.get(i).run(obstacle.getRoadLength()));
                if (team.get(i).getCondition())
                //console output
                outputProvider.print(team.get(i).jump(obstacle.getWallHeight()));
            }
        }
    }
    // Определяем победителя
    public void getWinner(){
        for (Sportsman sportsman : team){
            if (sportsman.getCondition()) {
                //console output
                outputProvider.print("\nПобедитель в команде " + teamname + " " + sportsman.info + " !!" );
            }
        }
    }
}
