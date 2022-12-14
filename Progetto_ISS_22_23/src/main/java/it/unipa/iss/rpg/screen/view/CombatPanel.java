package it.unipa.iss.rpg.screen.view;

import javax.swing.*;
import java.awt.*;

public class CombatPanel extends GamePanel{
    private JButton btnFight;
    public CombatPanel(){
        super();
    }

    public void setPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.orange);
        this.setDoubleBuffered(true);
        //panel.addKeyListener(handler);
        this.setFocusable(true);
        this.btnFight = new JButton("Attack");
    }

    public JButton getBtnFight() {
        return btnFight;
    }

    public int scaleTile() {
        return tileSize * scale;
    }
}
