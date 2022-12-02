package it.unipa.iss.rpg.screen.view;

import javax.swing.*;

public class Screen {
    private static Screen instance = null;
    private JFrame window;
    private GamePanel gamePanel;

    public Screen() {
        gamePanel = new WorldPanel();
        this.setWindow();
    }

    public Screen getIstance(){
        if (instance == null)
            instance = new Screen();
        return instance;
    }

    public void setWindow() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("RPG Game");
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
}
