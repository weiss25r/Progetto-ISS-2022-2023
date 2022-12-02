package it.unipa.iss.rpg.screen.view;

import javax.swing.*;

public abstract class Panel extends JPanel {
    public abstract JPanel getPanel();
    public abstract void setPanel();
    public abstract int scaleTile();
}
