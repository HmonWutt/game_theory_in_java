package org.gametheory.games;

import org.gametheory.enums.Action;
import org.gametheory.interfaces.Game;
import org.gametheory.players.AbstractPlayer;
import org.gametheory.players.PavlovianPlayer;
import org.gametheory.players.TitForTatAndForgivePlayer;

public class TwoPlayerGame implements Game {
    public final AbstractPlayer pavlovianPlayer;
    public final AbstractPlayer titForTatAndForgivePlayer;
    public int currentRound = 1;
    public int maxRounds;

    public TwoPlayerGame(int iterations) {
        this.pavlovianPlayer = new PavlovianPlayer();
        this.titForTatAndForgivePlayer = new TitForTatAndForgivePlayer();
        this.maxRounds = iterations;
    }

    @Override
    public void start() {
        System.out.println("PAV: " + pavlovianPlayer.getAction() + ", TFTF: " + titForTatAndForgivePlayer.getAction());
        while (currentRound <= maxRounds && (pavlovianPlayer.getBalance() != 0 || titForTatAndForgivePlayer.getBalance() != 0)) {
            round();
            currentRound++;
        }
        System.out.println("One's strategy: " + pavlovianPlayer.getStrategy() + ", Two strategy: " + titForTatAndForgivePlayer.getStrategy());

    }

    @Override
    public void round() {
        if (pavlovianPlayer.getAction() == Action.CO_OPERATE && titForTatAndForgivePlayer.getAction() == Action.CO_OPERATE) {
            pavlovianPlayer.resetExploit();
            titForTatAndForgivePlayer.resetExploit();
        } else if (pavlovianPlayer.getAction() == Action.EXPLOIT && titForTatAndForgivePlayer.getAction() == Action.CO_OPERATE) {
            titForTatAndForgivePlayer.gotExploited();
        } else if (titForTatAndForgivePlayer.getAction() == Action.EXPLOIT && pavlovianPlayer.getAction() == Action.CO_OPERATE) {
            pavlovianPlayer.gotExploited();
        } else if (titForTatAndForgivePlayer.getAction() == Action.EXPLOIT && pavlovianPlayer.getAction() == Action.EXPLOIT) {
            pavlovianPlayer.gotExploited();
            titForTatAndForgivePlayer.gotExploited();
        }
        pavlovianPlayer.play();
        titForTatAndForgivePlayer.play();
        System.out.println("PAV: " + pavlovianPlayer.getAction() + ", TFTF: " + titForTatAndForgivePlayer.getAction());

    }

}
