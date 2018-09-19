package za.co.wethinkcode.swingy.view;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.Main;
import za.co.wethinkcode.swingy.controller.Save;
import za.co.wethinkcode.swingy.model.characters.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
@Setter
public class Start extends JFrame{

    private JPanel rootPanelStart;
    private JPanel buttonPanel;
    private JPanel fieldPanel;

    private JButton newGameButton;
    private JButton continueButton;

    private JTextField nameTextArea;

    private JComboBox<String> heroTypeSelect;
    private JLabel header;

    public Start(){
       super("Welcome");
       setContentPane(rootPanelStart);
       pack();
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(600, 400);
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

       heroTypeSelect.addItem("Sorcerer");
       heroTypeSelect.addItem("Scout");
       heroTypeSelect.addItem("Monk");
       newGameButton.setEnabled(false);
       setVisible(true);



    }


}
