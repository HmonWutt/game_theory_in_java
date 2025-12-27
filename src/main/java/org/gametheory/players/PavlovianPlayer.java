package org.gametheory.players;

import org.gametheory.enums.Action;
import org.gametheory.strategies.Pavlovian;

import java.util.Random;

import static org.gametheory.enums.Action.CO_OPERATE;
import static org.gametheory.enums.Action.EXPLOIT;

public class PavlovianPlayer extends AbstractPlayer {

    public PavlovianPlayer() {
        Random rand = new Random();
        int result = rand.nextInt(2);
        this.action = result == 1 ? CO_OPERATE : EXPLOIT;
        this.strategy = new Pavlovian();
    }

    @Override
    public Action play() {
        if (strategy.shouldChangeAction(exploited, this.action)) {
            this.action = strategy.switchAction(action);

        }

        return this.action;
    }

}

