package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.view.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainGameController {
    public static List<Hero> heroList = new ArrayList<Hero>();
    public static List<Enemy> enemyList = new ArrayList<>();
    public static Hero player;
    public static Save save = new Save();

    public static void GUIrun(){
        StartController startController = new StartController();
    }

    public static void CLIrun(){
        CliController.start();
    }

    public static void readToList(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("heroes.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("")){throw new NumberFormatException("Make sure there are no empty lines in the text file");}
                Hero hero = Hero.newHero(line.split(",")[0], line.split(",")[1],
                        Integer.parseInt(line.split(",")[2]), Integer.parseInt(line.split(",")[3]),
                        line.split(",")[4], line.split(",")[5], line.split(",")[6]);
                if (ValidatorFactoryController.runValidator(hero)) {
                    heroList.add(hero);
                }
            }
        }catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    //Start

    public static void newGame(Hero hero){
        MainGameController.heroList.add(hero);
        MainGameController.player = MainGameController.heroList.get(MainGameController.heroList.size() - 1);
        save.saveNewHero(hero);
    }

    //Game

        //Move Checks
        public static Enemy checkCollide(){
            for (Enemy e: MainGameController.enemyList) {
                if (e.getX() == MainGameController.player.getY() && e.getY() == MainGameController.player.getX()){
                    return (e);
                }
            }
            return (null);
        }

    public static boolean checkWin(){
        if ( MainGameController.player.getY() == 0 || MainGameController.player.getY() == Map.mapSize - 1 ||
                MainGameController.player.getX() == 0 || MainGameController.player.getX() == Map.mapSize - 1){
            MainGameController.save.saveGame(MainGameController.heroList);
            return true;
        }
        return false;
    }


}
