package it.unipa.iss.rpg.screen.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentImage extends JComponent {
    final BufferedImage image;
    private final int x;
    private final int y;

    public ComponentImage(BufferedImage image, int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, 200, 200, null);
    }
}
