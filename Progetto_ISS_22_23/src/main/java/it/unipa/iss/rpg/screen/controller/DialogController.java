package it.unipa.iss.rpg.screen.controller;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.model.EventType;
import it.unipa.iss.rpg.screen.model.entitities.NPC;
import it.unipa.iss.rpg.screen.model.entitities.Player;
import it.unipa.iss.rpg.screen.view.DialogPanel;
import it.unipa.iss.rpg.screen.view.GamePanel;

public class DialogController {
    private NPC npc;

    public DialogController(NPC npc) {
        this.npc = npc;
    }

    public void runController() {
        DialogPanel dialogPanel = new DialogPanel(npc.getNpcSprite().getDialogIconPath(), npc.getDialog(), npc.getChoose_one(), npc.getChoose_two());
        dialogPanel.showDialog();
    }
}
