package za.co.wethinkcode.swingy.view;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.characters.Hero;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Getter
@Setter
public class Game extends JFrame {
    private JButton northButton;
    private JButton southButton;
    private JButton westButton;
    private JButton eastButton;

    private JTextArea gameplayLog;

    private JPanel rootPanelGame;
    private JPanel leftPanel;
    private JPanel statsPanel;

    private JLabel xpLabel;
    private JLabel levelLabel;
    private JLabel helmLabel;
    private JLabel weaponLabel;
    private JLabel armourLabel;
    private JLabel nameLabel;
    private JLabel typeLabel;

    public Game(final Hero player) {
        super("Swingy");
        setContentPane(rootPanelGame);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 1000);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);

        xpLabel.setText(Integer.toString(player.getXp()));
        levelLabel.setText(Integer.toString(player.getLevel()));
        weaponLabel.setText(player.getWeapon());
        helmLabel.setText(player.getHelm());
        armourLabel.setText(player.getArmour());
        nameLabel.setText(player.getName());
        typeLabel.setText(player.getClass().getSimpleName());


    }
}
