package it.unipa.iss.rpg.screen.view;

import javax.swing.*;
import java.awt.*;

public class CombatPanel {
    private JPanel panel;
    private Graphics graphics;
    private int screenHeight, screenWidth;
    private int maxRow, maxCol;
    private int scale, tileSize;
    //CombatHandler handler = new CombatHandler();

    public CombatPanel() {
        scale = 3;
        maxRow = 6;
        maxCol = 8;
        tileSize = 32;
        screenHeight = scaleTile() * maxRow;
        screenWidth = scaleTile() * maxCol;
        panel = new JPanel();
        this.setPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel() {
        panel.setPreferredSize(new Dimension(screenWidth, screenHeight));
        panel.setBackground(Color.darkGray);
        panel.setDoubleBuffered(true);
        //panel.addKeyListener(handler);
        panel.setFocusable(true);
    }

    public int scaleTile() {
        return tileSize * scale;
    }
}
