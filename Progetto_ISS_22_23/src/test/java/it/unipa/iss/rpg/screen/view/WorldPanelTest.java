package it.unipa.iss.rpg.screen.view;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

import javax.swing.*;
import java.awt.*;

class WorldPanelTest extends JPanel {
    WorldPanel worldPanel;
    protected Graphics graphics;
    protected int screenHeight, screenWidth;
    protected int maxRow, maxCol;
    protected int scale, tileSize;

    /*
    public WorldPanelTest(){
        worldPanel = new WorldPanel();

        scale = 3;
        tileSize = 32;

        maxRow = 6;
        maxCol = 8;
        screenHeight = worldPanel.scaleTile() * maxRow;
        screenWidth = worldPanel.scaleTile() * maxCol;
        this.testSetPanel();
    }
    */

    @BeforeEach
    public void setUp(){
        worldPanel = new WorldPanel();
        assertNotNull(worldPanel);
    }

    @AfterEach
    public void tearDown(){
        worldPanel = null;
        assertNull(worldPanel);
    }

    @Test
    public void testScaleTile(){
        assertEquals(worldPanel.scaleTile(),tileSize * scale);
    }

    @Test
    public void testSetPanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        //panel.addKeyListener(handler);
        this.setFocusable(true);

        assertEquals(worldPanel.getPanel().getComponents(),this.getComponents());
    }

}