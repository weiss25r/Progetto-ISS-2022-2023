package it.unipa.iss.rpg.screen.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DialogPanel extends GamePanel{

    JFrame dialogFrame = new JFrame();
    JPanel npcIcon = new JPanel();
    JPanel dialogBox = new JPanel();
    JPanel answerDialogBox = new JPanel();

    //dialogData;
    JTextArea text = new JTextArea("Buongiorno Scrum Master, ha avuto una bella giornata?\n" +
                                   "Ne sono alquanto contento, andiamo a cominciare\n" +
                                   "una nuova giornata lavorativa\n");
    JButton btn1 = new JButton("Yes");
    JButton btn2 = new JButton("No");

    public DialogPanel(){
        super();
        setPanel();
    }

    public void setPanel(){
        this.setSize(new Dimension(screenWidth*3, screenHeight/3));
        this.setLayout(new BorderLayout());
        this.setDoubleBuffered(true);

        npcIcon.setBorder(new EmptyBorder(10, 10, 10, 10));
        npcIcon.setBackground(new Color(238,203,155));
        dialogBox.setBorder(new EmptyBorder(10, 10, 10, 10));
        dialogBox.setBackground(new Color(238,203,155));
        answerDialogBox.setBorder(new EmptyBorder(10, 10, 10, 10));
        answerDialogBox.setBackground(new Color(238,203,155));

        text.setBackground(null);
        text.setFont(new Font("Calibri", Font.PLAIN, 22));
        text.setFocusable(false);

        answerDialogBox.setLayout(new GridLayout(1,5));

        btn1.addActionListener(e -> this.closeDialog());
        btn2.addActionListener(e -> this.closeDialog());

        npcIcon.add(new JLabel(new ImageIcon("src/res/npc/bob.png")));
        dialogBox.add(text);
        answerDialogBox.add(new Label());
        answerDialogBox.add(btn1);
        answerDialogBox.add(new Label());
        answerDialogBox.add(btn2);
        answerDialogBox.add(new Label());

        this.add(npcIcon,BorderLayout.WEST);
        this.add(dialogBox,BorderLayout.EAST);
        this.add(answerDialogBox,BorderLayout.SOUTH);

        dialogFrame.getContentPane().add(this);
        dialogFrame.setUndecorated(true);
        dialogFrame.pack();
        dialogFrame.setLocationRelativeTo(null);
    }

    public void showDialog(){
        dialogFrame.setVisible(true);
    }

    public void closeDialog(){
        dialogFrame.setVisible(false);
        dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public int scaleTile() {
        return 0;
    }

}
