package it.unipa.iss.rpg.combat.view;

import it.unipa.iss.rpg.screen.view.ComponentImage;
import it.unipa.iss.rpg.screen.view.GamePanel;

import javax.swing.*;
import java.awt.*;

public class CombatPanel extends GamePanel {
    private JLabel lblPlayerHp;
    private JLabel lblPlayerStamina;
    private JLabel lblEnemyHp;
    private JPanel stats;
    private JButton btnFight,btnAbility,btnInv;
    private JPanel btns;

    public CombatPanel(){
        super();
        setPanel();
    }

    public void setPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.setDoubleBuffered(true);
        //panel.addKeyListener(handler);

        btns = new JPanel();
        btns.setLayout(new GridLayout(1,3));
        this.btnFight = new JButton("Attack");
        this.btnFight.setFont(new Font("Arial", Font.PLAIN, 20));
        this.btnAbility = new JButton("Ability");
        this.btnAbility.setFont(new Font("Arial", Font.PLAIN, 20));
        this.btnInv = new JButton("Inventory");
        this.btnInv.setFont(new Font("Arial", Font.PLAIN, 20));
        btns.add(btnFight);
        btns.add(btnAbility);
        btns.add(btnInv);
        this.add(btns,BorderLayout.SOUTH);

        stats = new JPanel();
        stats.setBackground(Color.black);
        stats.setLayout(new GridLayout(2,5));
        this.lblPlayerHp = new JLabel("HP: 100");
        this.lblPlayerHp.setForeground(Color.white);
        this.lblPlayerHp.setFont(new Font("Arial", Font.PLAIN, 20));
        this.lblPlayerStamina = new JLabel("SP: 50");
        this.lblPlayerStamina.setForeground(Color.white);
        this.lblPlayerStamina.setFont(new Font("Arial", Font.PLAIN, 20));
        this.lblEnemyHp = new JLabel("HP: 100");
        this.lblEnemyHp.setForeground(Color.white);
        this.lblEnemyHp.setFont(new Font("Arial", Font.PLAIN, 20));
        stats.add(lblPlayerHp);
        stats.add(lblEnemyHp);
        stats.add(lblPlayerStamina);
        this.add(stats,BorderLayout.NORTH);

        this.setFocusable(true);
    }

    public JButton getBtnFight() {
        return btnFight;
    }

    public int scaleTile() {
        return tileSize * scale;
    }

    public void setLblPlayerHp(String playerHp){
        this.lblPlayerHp.setText(playerHp);
    }
    public void setLblEnemyHp(String EnemyHp){
        this.lblEnemyHp.setText(EnemyHp);
    }
    public void setLblPlayerStamina(String playerStamina){
          this.lblPlayerStamina.setText(playerStamina);
     }

    public void setEnemyImage(ComponentImage mob) {
        this.add(mob, BorderLayout.CENTER);
    }

    public JLabel getLblPlayerHp() {
        return lblPlayerHp;
    }

    public JLabel getLblPlayerStamina() {
        return lblPlayerStamina;
    }

    public JLabel getLblEnemyHp() {
        return lblEnemyHp;
    }
}
