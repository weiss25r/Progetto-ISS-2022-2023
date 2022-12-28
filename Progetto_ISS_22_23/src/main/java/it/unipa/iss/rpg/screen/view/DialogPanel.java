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
    JTextArea text;
    JButton btn1;
    JButton btn2;
    String path;

    public DialogPanel(String path, String dialog, String choose_one, String choose_two){
        super();
        this.path = path;
        text = new JTextArea(dialog);
        btn1 = new JButton(choose_one);
        btn2 = new JButton(choose_two);
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
        //TODO: add some event for btn1
        btn2.addActionListener(e -> this.closeDialog());
        //TODO: add some event for btn2

        npcIcon.add(new JLabel(new ImageIcon(path)));
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
        dialogFrame.dispose();
    }

    @Override
    public int scaleTile() {
        return 0;
    }

}
