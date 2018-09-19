package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.view.Game;
import za.co.wethinkcode.swingy.view.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GuiController {

    public static Game gameView = new Game(MainGameController.player);
    public static Map map = new Map(MainGameController.player);
    public static EnemyController enemyController = new EnemyController();

    public GuiController() {
        enemyController.initEnemies(map);
        map.populateMap();
        map.printMap(gameView.getGameplayLog());
        initListeners();
    }

    public void initListeners() {
        gameView.getNorthButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.getX() > 0) {
                    MainGameController.player.moveNorth(map, enemyController);
                    map.printMap(gameView.getGameplayLog());
                    doChecks();
                }
            }
        });

        gameView.getEastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.getY() < Map.mapSize - 1) {
                    MainGameController.player.moveEast(map, enemyController);
                    map.printMap(gameView.getGameplayLog());
                    doChecks();
                }
            }
        });

        gameView.getWestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.getY() > 0) {
                    MainGameController.player.moveWest(map, enemyController);
                    map.printMap(gameView.getGameplayLog());
                    doChecks();
                }
            }
        });
        gameView.getSouthButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.getX() < Map.mapSize - 1) {
                    MainGameController.player.moveSouth(map, enemyController);
                    map.printMap(gameView.getGameplayLog());
                    doChecks();
                }
            }
        });

        gameView.getXpLabel().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                gameView.getXpLabel().setText(Integer.toString(MainGameController.player.getXp()));
                gameView.getLevelLabel().setText(Integer.toString(MainGameController.player.getLevel()));
                gameView.getWeaponLabel().setText(MainGameController.player.getWeapon());
                gameView.getArmourLabel().setText(MainGameController.player.getArmour());
                gameView.getHelmLabel().setText(MainGameController.player.getHelm());
            }
        });
    }

    public void doChecks(){
        Enemy en = MainGameController.checkCollide();
        if (en != null){
            gameView.setVisible(false);
            BattleController battleController = new BattleController(en);
        }
        else if(MainGameController.checkWin() ){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "You win.");
            System.exit(0);
        }
    }
}

