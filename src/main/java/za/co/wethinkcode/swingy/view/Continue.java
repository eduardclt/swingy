package za.co.wethinkcode.swingy.view;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.controller.MainGameController;
import za.co.wethinkcode.swingy.model.characters.Hero;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Continue extends JFrame{
    private JButton selectButton;
    private JButton backButton;

    private JPanel rootPanelContinue;
    private JList<String> list1;
    private JTextArea textArea1;

    public Continue(){
        super("Saved Games");
        setContentPane(rootPanelContinue);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        DefaultListModel<String> model = new DefaultListModel<String>();
        for(Hero s:MainGameController.heroList){
            model.addElement(s.name);
        }
        list1.setModel(model);
        selectButton.setEnabled(false);

        setVisible(true);
    }


}
