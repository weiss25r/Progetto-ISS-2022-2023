package it.unipa.iss.rpg.screen.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AbilityPanel extends GamePanel{
    private JFrame abilityFrame = new JFrame();
    private JPanel layout = new JPanel();
    private JPanel ability1 = new JPanel();
    private JPanel ability2 = new JPanel();
    private JPanel ability3 = new JPanel();

    private JPanel points;

    public AbilityPanel(){
        setPanel();
    }

    public void setPanel(){
        this.setSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(95,110,127));
        this.setLayout(new BorderLayout());
        this.setDoubleBuffered(true);

        ability1.setLayout(new GridLayout(5,3));
        ability1.setBorder(new EmptyBorder(10, 10, 10, 10));
        ability2.setLayout(new GridLayout(5,3));
        ability2.setBorder(new EmptyBorder(10, 10, 10, 10));
        ability3.setLayout(new GridLayout(5,3));
        ability3.setBorder(new EmptyBorder(10, 10, 10, 10));

        ability1.add(new JLabel());
        ability1.add(new JButton("Fuoco"));
        ability1.add(new JLabel());
        ability2.add(new JLabel());
        ability2.add(new JButton("Acqua"));
        ability2.add(new JLabel());
        ability3.add(new JLabel());
        ability3.add(new JButton("Vento"));
        ability3.add(new JLabel());

        for(int i = 2; i <= 5; i++){
            ability1.add(new JButton("Ability" + (i - 1)));
            ability1.add(new JLabel());
            ability1.add(new JButton("Ability" + (i - 1)));

            ability2.add(new JButton("Ability" + (i - 1)));
            ability2.add(new JLabel());
            ability2.add(new JButton("Ability" + (i - 1)));

            ability3.add(new JButton("Ability" + (i - 1)));
            ability3.add(new JLabel());
            ability3.add(new JButton("Ability" + (i - 1)));
        }

        layout.add(ability1,BorderLayout.NORTH);
        layout.add(ability1,BorderLayout.WEST);
        layout.add(ability2,BorderLayout.CENTER);
        layout.add(ability3,BorderLayout.EAST);

        abilityFrame.getContentPane().add(layout);
        abilityFrame.pack();
        abilityFrame.setLocationRelativeTo(null);
    }

    public void showAbility(){
        abilityFrame.setVisible(true);
    }

    public void closeAbility(){
        abilityFrame.dispose();
    }

    @Override
    public int scaleTile() {
        return 0;
    }
}
