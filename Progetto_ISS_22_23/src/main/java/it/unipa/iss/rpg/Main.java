package it.unipa.iss.rpg;

import it.unipa.iss.rpg.screen.view.DialogPanel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.startGame();
    }
}