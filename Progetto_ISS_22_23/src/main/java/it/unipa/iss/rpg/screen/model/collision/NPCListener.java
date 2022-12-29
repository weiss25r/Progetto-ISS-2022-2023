package it.unipa.iss.rpg.screen.model.collision;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.model.entitities.NPC;
import it.unipa.iss.rpg.screen.view.DialogPanel;

public class NPCListener implements CollisionListener{
    private NPC npc;

    public NPCListener(NPC npc) {
        this.npc = npc;
    }

    @Override
    public void update(GameController gameController) { }

    @Override
    public void update() {
        DialogPanel dialogPanel = new DialogPanel(npc.getNpcSprite().getDialogIconPath(), npc.getDialog(), npc.getChoose_one(), npc.getChoose_two());
        dialogPanel.showDialog();
    }
}
