package org.gametheory.players;

import org.gametheory.enums.Action;
import org.gametheory.interfaces.Player;
import org.gametheory.interfaces.Strategy;

public abstract class AbstractPlayer implements Player {
    protected Action action;
    protected Strategy strategy;
    protected boolean exploited = false;
    protected int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public void gotExploited() {
        exploited = true;
        balance--;
    }

    public void decreaseBalance() {
        balance--;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Strategy getStrategy() {
        return strategy;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public void setAction(Action action) {
        this.action = action;
    }

    public void resetExploit(){
        this.exploited = false;
    }
}
