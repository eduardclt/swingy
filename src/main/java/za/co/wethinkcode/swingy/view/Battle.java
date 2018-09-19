package za.co.wethinkcode.swingy.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class Battle extends JFrame {
    private JTextArea battleLog;

    private JButton attackButton;
    private JButton fleeButton;

    private JPanel rootPanelBattle;
    private JPanel enemyPanel;
    private JPanel playerPanel;
    private JPanel battlePanel;

    private JLabel enemyHealth;
    private JLabel playerHealth;
    private JLabel enemyAttack;
    private JLabel playerAttack;
    private JLabel enemyDefence;
    private JLabel playerDefence;
    private JButton okButton;
    private JLabel enemyType;
    private JButton continueButton;

    public Battle() {
        super("Battle");
        setContentPane(rootPanelBattle);
        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);




    }

}
