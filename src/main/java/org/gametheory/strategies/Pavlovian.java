package org.gametheory.strategies;

import org.gametheory.enums.Action;
import org.gametheory.interfaces.Strategy;

import static org.gametheory.enums.Action.CO_OPERATE;
import static org.gametheory.enums.Action.EXPLOIT;

public class Pavlovian implements Strategy {
    @Override
    public boolean shouldChangeAction(boolean exploited, Action lastAction) {
        return exploited ;
    }

    @Override
    public Action switchAction(Action action) {
        return action == CO_OPERATE ? EXPLOIT : CO_OPERATE;
    }
}
