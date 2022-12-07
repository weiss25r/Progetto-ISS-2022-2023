package it.unipa.iss.rpg.screen.view;

import javax.swing.*;

public class Screen {
    private static Screen instance = null;
    private JFrame window;

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    private GamePanel gamePanel;

    private Screen() {
        gamePanel = new WorldPanel();
        this.setWindow();
    }

    public static Screen getIstance(){
        if (instance == null)
            instance = new Screen();
        return instance;
    }

    public void setWindow() {
        this.gamePanel = new WorldPanel();
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("RPG Game");
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    public JFrame getWindow() {
        return window;
    }
}
