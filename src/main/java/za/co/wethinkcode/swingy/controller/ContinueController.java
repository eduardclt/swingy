package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.view.Continue;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueController {

    Continue continueView = new Continue();

    public ContinueController(){
        initListeners();
    }

    public void initListeners(){
        continueView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartController startController = new StartController();
                continueView.dispose();
            }
        });

        continueView.getList1().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                continueView.getSelectButton().setEnabled(true);
                int i = continueView.getList1().getSelectedIndex();
                continueView.getTextArea1().setText("Type: " + MainGameController.heroList.get(i).getClass().getSimpleName());
                continueView.getTextArea1().append("\nLevel: " + MainGameController.heroList.get(i).level + "\nExperience: " + MainGameController.heroList.get(i).xp);
            }
        });

        continueView.getSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGameController.player = MainGameController.heroList.get(continueView.getList1().getSelectedIndex());
                GuiController guiController = new GuiController();
                continueView.dispose();
            }
        });
    }
}
