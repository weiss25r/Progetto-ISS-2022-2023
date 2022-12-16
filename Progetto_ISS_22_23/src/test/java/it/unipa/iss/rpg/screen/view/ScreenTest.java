package it.unipa.iss.rpg.screen.view;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

import javax.swing.*;

class ScreenTest {
    private Screen screen;
    private JFrame window;
    private WorldPanelTest gamePanelTest;

    @BeforeEach
    public void setUp(){
        /*
        screen = Screen.getIstance();
        assertNotNull(screen);
        */
    }

    @AfterEach
    public void tearDown(){
        /*
        screen = null;
        assertNull(screen);
         */
    }

    @Test
    public void testSetWindow(){
        gamePanelTest =  new WorldPanelTest();
        /*To test this function must un-comment the
          Constructor in WorldPanelTest*/

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("RPG Game");
        window.add(gamePanelTest);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);

        assertEquals(screen.getWindow().getOwnedWindows(),window.getOwnedWindows());
    }
}