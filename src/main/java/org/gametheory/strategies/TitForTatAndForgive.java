package org.gametheory.strategies;

import org.gametheory.enums.Action;
import org.gametheory.interfaces.Strategy;

import static org.gametheory.enums.Action.CO_OPERATE;
import static org.gametheory.enums.Action.EXPLOIT;

public class TitForTatAndForgive implements Strategy {
//    private int flag = 0;

    @Override
    public boolean shouldChangeAction(boolean exploited, Action lastAction) {
//        if (exploited) {
//            flag++;
//        }
        return exploited || lastAction == EXPLOIT ;
    }

    @Override
    public Action switchAction(Action action) {
//        if (flag == 0) {
//            return CO_OPERATE;
//        } else if (flag == 1) {
//            return EXPLOIT;
//        } else {
//            flag = 0;
//            return CO_OPERATE;
//        }
        return action == EXPLOIT ? CO_OPERATE : EXPLOIT;
    }
}
