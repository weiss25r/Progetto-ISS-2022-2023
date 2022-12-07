package it.unipa.iss.rpg.screen.view;

import javax.swing.*;
import java.awt.*;

public class WorldPanel extends GamePanel {

    public WorldPanel(){
        setPanel();
    }

    public void setPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        //panel.addKeyListener(handler);
        this.setFocusable(true);
    }

    public JPanel getPanel(){
        return this;
    }

    public int scaleTile() {
        return tileSize * scale;
    }
}
