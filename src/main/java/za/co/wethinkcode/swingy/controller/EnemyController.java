package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.view.Map;

import java.util.Random;

public class EnemyController {

    public EnemyController(){

    }

    public void initEnemies(Map map) {
        int i = 0;
        int k = 0;

        while (i < map.mapSize) {
            while (k < map.mapSize) {
                int random = new Random().nextInt(15);
                if (i != MainGameController.player.getX() || k != MainGameController.player.getY()) {
                    switch (random) {
                        case 1:
                            MainGameController.enemyList.add(Enemy.newEnemy("Dragon", i, k));
                            break;
                        case 5:
                            MainGameController.enemyList.add(Enemy.newEnemy("Pegasus", i, k));
                            break;
                        case 9:
                            MainGameController.enemyList.add(Enemy.newEnemy("Werewolf", i, k));
                            break;
                        default:
                            break;
                    }
                }
                k++;
            }
            k = 0;
            i++;
        }
    }

    public void moveEnemies(Map map){
        for (Enemy e : MainGameController.enemyList) {
            int random = new Random().nextInt(10);
            switch (random) {
                case 1: //North
                    if (e.getX() > 0) {
                        e.setX(e.getX() - 1);
                    }
                    break;
                case 2: //East
                    if (e.getY() < map.mapSize - 1) {
                        e.setY(e.getY() + 1);
                    }
                    break;
                case 3: //West
                    if (e.getY() > 0) {
                        e.setY(e.getY() - 1);
                    }
                    break;
                case 4: //South
                    if (e.getX() < map.mapSize - 1) {
                        e.setX(e.getX() + 1);
                    }
                    break;
                    default:
                        break;

            }
            }
        }

    }

