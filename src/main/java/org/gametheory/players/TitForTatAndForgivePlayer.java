package org.gametheory.players;

import org.gametheory.enums.Action;
import org.gametheory.interfaces.Player;
import org.gametheory.interfaces.Strategy;
import org.gametheory.strategies.TitForTatAndForgive;

import java.util.Random;

import static org.gametheory.enums.Action.CO_OPERATE;
import static org.gametheory.enums.Action.EXPLOIT;

public class TitForTatAndForgivePlayer extends AbstractPlayer {

    public TitForTatAndForgivePlayer() {
        this.action = CO_OPERATE;
        this.strategy = new TitForTatAndForgive();
    }

    @Override
    public Action play() {
        Action lastAction = this.action;
        if (!strategy.shouldChangeAction(exploited,lastAction)) {
            return lastAction;
        }

        Action newAction = strategy.switchAction(lastAction);
        this.action = newAction;
        return newAction;
    }

}

