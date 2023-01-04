package it.unipa.iss.rpg.screen.view;

import javax.swing.*;

public class Screen {
    private JFrame window;
    private GamePanel gamePanel;

    public Screen() { }

    public void setGamePanel(GamePanel gamePanel) {
        window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(gamePanel);
        window.setTitle("RPG Game");
        window.pack();

        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    public JFrame getWindow() {
        return window;
    }
}
