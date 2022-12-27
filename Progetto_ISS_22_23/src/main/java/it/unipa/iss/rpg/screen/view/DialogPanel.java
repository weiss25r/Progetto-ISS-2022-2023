package it.unipa.iss.rpg.screen.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DialogPanel extends GamePanel{

    JFrame dialogFrame = new JFrame();
    JPanel npcIcon = new JPanel();
    JPanel dialogBox = new JPanel();
    JPanel answerDialogBox = new JPanel();

    JTextArea text = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

    //dialogData;

    public DialogPanel(){
        super();
        setPanel();
        dialogFrame.setVisible(false);
    }

    public void setPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight/3));
        this.setBackground(new Color(238,203,155));
        this.setLayout(new BorderLayout());
        this.setDoubleBuffered(true);

        npcIcon.setBorder(new EmptyBorder(10, 10, 10, 30));
        dialogBox.setBorder(new EmptyBorder(10, 10, 10, 10));
        answerDialogBox.setBorder(new EmptyBorder(10, 10, 10, 10));

        answerDialogBox.setLayout(new GridLayout(1,4));

        npcIcon.add(new JLabel(new ImageIcon("src/res/npc/bob.png")));
        dialogBox.add(text);
        answerDialogBox.add(new Label());
        answerDialogBox.add(new Button("Yes"));
        answerDialogBox.add(new Button("No"));
        answerDialogBox.add(new Label());

        this.add(npcIcon,BorderLayout.WEST);
        this.add(dialogBox,BorderLayout.EAST);
        this.add(answerDialogBox,BorderLayout.SOUTH);

        dialogFrame.setUndecorated(true);
        dialogFrame.add(this);
        dialogFrame.setSize(500,200);
    }

    public void showDialog(){
        dialogFrame.setVisible(true);
    }

    public void closeDialog(){
        dialogFrame.setVisible(false);
    }

    @Override
    public int scaleTile() {
        return 0;
    }

}
