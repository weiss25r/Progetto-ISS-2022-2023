package it.unipa.iss.rpg.screen.model.collision;

import it.unipa.iss.rpg.GameController;
import it.unipa.iss.rpg.screen.controller.LevelController;
import it.unipa.iss.rpg.screen.controller.WorldController;
import it.unipa.iss.rpg.screen.model.Level;
import it.unipa.iss.rpg.screen.model.entitities.Npc;
import it.unipa.iss.rpg.screen.view.DialogPanel;

public class NPCListener implements CollisionListener{
    private Npc npc;
    private boolean lastDecision;

    public NPCListener(Npc npc) {
        this.npc = npc;
    }

    @Override
    public void update(GameController gameController) {
        LevelController worldController = (LevelController) gameController;
        DialogPanel dialogPanel = new DialogPanel(npc.getNpcSprite().getDialogIconPath(), npc.getDialog(), npc.getChoose_one(), npc.getChoose_two());
        dialogPanel.showDialog();

        dialogPanel.getBtn1().addActionListener(e -> {
            dialogPanel.closeDialog();
            worldController.updateDecisionTree(true);
        });

        dialogPanel.getBtn2().addActionListener(e -> {
            dialogPanel.closeDialog();
            worldController.updateDecisionTree(false);
        });
    }

    @Override
    public void update() {
    }

}
