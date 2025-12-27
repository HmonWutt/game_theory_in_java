package org.gametheory.interfaces;

import org.gametheory.enums.Action;

public interface Player {
    int getBalance();
    void setBalance(int balance);

    void setStrategy(Strategy strategy);
    Strategy getStrategy();

    Action getAction();
    void setAction(Action action);

    Action play();

}
