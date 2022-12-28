package it.unipa.iss.rpg.screen.model.collision;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.view.DialogPanel;

public class NPCListener implements CollisionListener{
    /*TODO: NPC must send other two variables (Listener or Extra Class)
            which the Player do the choose, choose_one and choose_two
            are only the text of answers*/

    @Override
    public void update(GameController gameController) { }

    @Override
    public void update(String path, String dialog, String choose_one, String choose_two) {
        DialogPanel dialogPanel = new DialogPanel(path, dialog, choose_one, choose_two);
        dialogPanel.showDialog();
    }
}
