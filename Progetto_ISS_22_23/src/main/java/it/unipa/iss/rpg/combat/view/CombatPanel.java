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
    private JButton btnAttack,btnAbility,btnInv;
    private JPanel interactive;
    private JPanel fight;
    private JPanel ability;

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

        interactive = new JPanel();

        setFight();

        setAbility();

        this.add(interactive,BorderLayout.SOUTH);

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

    public void setFight(){
        this.btnAttack = new JButton("Attack");
        this.btnAttack.setFont(new Font("Arial", Font.PLAIN, 20));
        this.btnAbility = new JButton("Ability");
        this.btnAbility.setFont(new Font("Arial", Font.PLAIN, 20));
        this.btnInv = new JButton("Inventory");
        this.btnInv.setFont(new Font("Arial", Font.PLAIN, 20));

        fight = new JPanel();
        fight.setLayout(new GridLayout(1,3));
        fight.add(btnAttack);
        fight.add(btnAbility);
        fight.add(btnInv);

        interactive.add(fight);

        btnAbility.addActionListener(e -> {ability.setVisible(true);
                                           fight.setVisible(false);});
    }

    public void setAbility(){
        JButton btn1,btn2,btn3,btn4;

        ability = new JPanel(new GridLayout(1,4));
        ability.add(btn1 = new JButton("Healing"));
        ability.add(btn2 = new JButton("Study Power"));
        ability.add(btn3 = new JButton("Cursed Attack"));
        ability.add(btn4 = new JButton("Sinner Attack"));

        btn1.setFont(new Font("Arial", Font.PLAIN, 20));
        btn2.setFont(new Font("Arial", Font.PLAIN, 20));
        btn3.setFont(new Font("Arial", Font.PLAIN, 20));
        btn4.setFont(new Font("Arial", Font.PLAIN, 20));

        btn1.addActionListener(e -> effect1());
        btn2.addActionListener(e -> effect2());
        btn3.addActionListener(e -> effect3());
        btn4.addActionListener(e -> effect4());

        ability.setVisible(false);

        interactive.add(ability);
    }

    @Override
    public int scaleTile() {
        return tileSize * scale;
    }

    public void effect1(){
        ability.setVisible(false);
        fight.setVisible(true);
    }

    public void effect2(){
        ability.setVisible(false);
        fight.setVisible(true);
    }

    public void effect3(){
        ability.setVisible(false);
        fight.setVisible(true);
    }

    public void effect4(){
        ability.setVisible(false);
        fight.setVisible(true);
    }

    public void setLblPlayerHp(String playerHp){
        this.lblPlayerHp.setText(playerHp);
    }

    public JLabel getLblPlayerHp() {
        return lblPlayerHp;
    }

    public void setLblPlayerStamina(String playerStamina){
        this.lblPlayerStamina.setText(playerStamina);
    }

    public JLabel getLblPlayerStamina() {
        return lblPlayerStamina;
    }

    public void setLblEnemyHp(String EnemyHp){
        this.lblEnemyHp.setText(EnemyHp);
    }

    public JLabel getLblEnemyHp() {
        return lblEnemyHp;
    }

    public void setEnemyImage(ComponentImage mob) {
        this.add(mob, BorderLayout.CENTER);
    }

    public JButton getBtnFight() {
        return btnAttack;
    }
}
