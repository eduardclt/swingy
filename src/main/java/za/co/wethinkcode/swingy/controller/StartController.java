package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.view.Start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartController {

    public Start startView = new Start();

    public StartController(){
        initListeners();
    }

    public void initListeners(){
        startView.getNewGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (!startView.getNameTextArea().getText().contains(",") && startView.getNameTextArea().getText().length() > 4) {
                    Hero hero = Hero.newHero(startView.getNameTextArea().getText(), startView.getHeroTypeSelect().getSelectedItem().toString());
                    MainGameController.newGame(hero);
                    GuiController guiController = new GuiController();
                    startView.dispose();
                }
                else
                {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Invalid Input. Name must be more than 4 characters and cannot contain a ','.");
                }

            }

        });

        startView.getContinueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContinueController continueController = new ContinueController();
                startView.dispose();
            }
        });

        startView.getNameTextArea().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (!startView.getNameTextArea().getText().equals("")) {
                    startView.getNewGameButton().setEnabled(true);
                }else if (startView.getNameTextArea().getText().equals("")) {
                    startView.getNewGameButton().setEnabled(false);
                }

            }
        });
    }


}
