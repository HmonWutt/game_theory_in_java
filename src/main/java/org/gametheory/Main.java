package org.gametheory;

import org.gametheory.games.TwoPlayerGame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TwoPlayerGame game = new TwoPlayerGame(100);
        game.start();

    }
}