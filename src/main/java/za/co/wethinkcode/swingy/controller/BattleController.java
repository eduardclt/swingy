package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.Main;
import za.co.wethinkcode.swingy.model.characters.Enemy;
import za.co.wethinkcode.swingy.view.Battle;
import za.co.wethinkcode.swingy.view.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BattleController {
    Battle battleView = new Battle();
    Enemy enemy;

    public BattleController(Enemy enemy){
        this.enemy = enemy;
        initListeners();
    }

    public void initListeners(){

        battleView.getBattleLog().setText("Do you wanna attack or flee?\n");
        battleView.getPlayerAttack().setText(Integer.toString(MainGameController.player.getAttack()));
        battleView.getPlayerDefence().setText(Integer.toString(MainGameController.player.getDefence()));
        battleView.getPlayerHealth().setText(Integer.toString(MainGameController.player.getHp()));
        battleView.getEnemyAttack().setText(Integer.toString(enemy.getAttack()));
        battleView.getEnemyDefence().setText(Integer.toString(enemy.getDefence()));
        battleView.getEnemyHealth().setText(Integer.toString(enemy.getHp()));
        battleView.getEnemyType().setText(enemy.getClass().getSimpleName());

        battleView.getAttackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleView.getFleeButton().setEnabled(false);
                battle();
            }
        });

        battleView.getFleeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int random = new Random().nextInt(2);
                switch (random){
                    case 1:
                        battleView.getBattleLog().setText("You were unable to flee you have to fight!");
                        battleView.getFleeButton().setEnabled(false);
                        break;
                    case 0:
                       GuiController.gameView.setVisible(true);
                        //GuiController gameController = new GuiController(MainGameController.player);
                        battleView.dispose();
                }
            }
        });

        battleView.getOkButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                }
        });

        battleView.getContinueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainGameController.player.updateStats(enemy) == true)
                {
                    GuiController.map = new Map(MainGameController.player);
                    GuiController.enemyController.initEnemies(GuiController.map);
                    GuiController.map.populateMap();
                    GuiController.map.printMap(GuiController.gameView.getGameplayLog());
                }
                battleView.getContinueButton().setVisible(false);
                MainGameController.save.saveGame(MainGameController.heroList);
                GuiController.gameView.setVisible(true);
                battleView.dispose();

            }
        });
    }

    public void battle(){
        int enemyHP;
        int playerHP = 0;
        String artefact;
        while (true) {
            if (MainGameController.player.getHp()  <= 0) {
                battleView.getBattleLog().append("You're dead.\n");
                MainGameController.player.setHp(0);
                battleView.getAttackButton().setEnabled(false);
                battleView.getOkButton().setVisible(true);

                break;
            }
            else if (enemy.getHp() <= 0) {
                battleView.getBattleLog().append("You have destroyed the enemy\n");
                MainGameController.enemyList.remove(enemy);
                if((artefact = MainGameController.player.randomWeapon(enemy)) != "") {
                    battleView.getBattleLog().append("You picked up a " + artefact);
                    MainGameController.save.saveGame(MainGameController.heroList);
                }
                battleView.getContinueButton().setVisible(true);
                battleView.getAttackButton().setEnabled(false);
                enemy.setHp(0);
                MainGameController.player.setHp(100);
                if(MainGameController.checkWin() ) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "You win.");
                    System.exit(0);
                }
                break;
            }
            else {
                MainGameController.player.attack(enemy);
                enemyHP = enemy.getHp();
                if (enemyHP <= 0){
                    enemyHP = 0;
                }else{
                    battleView.getBattleLog().append("Player attacked enemy with " + MainGameController.player.getAttack() + " attack.\n Enemy hp is now " + enemyHP + "\n");
                    enemy.attack(MainGameController.player);
                    playerHP = MainGameController.player.getHp();
                    if (playerHP < 0){
                        playerHP = 0;
                    }
                    battleView.getBattleLog().append("Enemy attacked player with " + enemy.getAttack() + " attack.\n Player hp is now " + playerHP + "\n");
                }

                battleView.getPlayerHealth().setText(Integer.toString(playerHP));
                battleView.getEnemyHealth().setText(Integer.toString(enemyHP));
            }
        }

    }
}
