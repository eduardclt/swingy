package za.co.wethinkcode.swingy.view;

import za.co.wethinkcode.swingy.Colors;
import za.co.wethinkcode.swingy.controller.MainGameController;
import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.model.characters.Hero;

import javax.swing.*;

public class Map {
    public static int mapSize;
    public static String[][] map;

    public Map(Hero player){
        this.mapSize = (player.getLevel() - 1) * 5 + 10 - (player.getLevel() % 2);
        this.map = new String[mapSize][mapSize];
        player.setX(mapSize/2);
        player.setY(mapSize/2);
    }

    public void populateMap() {
        for (int i = 0; i < mapSize; i++)
        {
            for (int k = 0; k < mapSize; k++)
            {
                this.map[i][k] = " ";
                for (Enemy e: MainGameController.enemyList) {
                    if (e.getY() == i && e.getX() == k)
                        this.map[i][k] = e.getClass().getSimpleName().substring(0,1);
                }
            }
        }
    }

    public static void printMap(){
        int i = 0;
        int k = 0;

        map[MainGameController.player.getX()][MainGameController.player.getY()] = "#";
        while(i < mapSize){
            while (k < mapSize){
                if (map[i][k].equals("#")){
                    System.out.print(Colors.RED + map[i][k]);
                }else{
                System.out.print(Colors.CYAN + map[i][k]);
                }
                System.out.print(" ");
                k++;
            }
            k = 0;
            i++;
            System.out.print("\n");
        }
    }

    public static void printMap(JTextArea gameplayLog){
        int i = 0;
        int k = 0;

        map[MainGameController.player.getX()][MainGameController.player.getY()] = "#";
        gameplayLog.setText("");
        while(i < mapSize){
            while (k < mapSize){
                gameplayLog.append(map[i][k]);
                gameplayLog.append("  ");
                k++;
            }
            k = 0;
            i++;
            gameplayLog.append("\n");
            gameplayLog.append("\n");
        }
    }


}