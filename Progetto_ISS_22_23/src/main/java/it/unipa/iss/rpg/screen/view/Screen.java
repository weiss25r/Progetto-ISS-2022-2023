package it.unipa.iss.rpg.screen.view;

import javax.swing.*;

public class Screen {
    private Screen instance = null;
    private JFrame window;
    private GamePanel gamePanel;

    public Screen() {}
    public Screen(GamePanel gamePanel) {
        setGamePanel(gamePanel);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("RPG Game");
        window.getContentPane().add(gamePanel);
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
