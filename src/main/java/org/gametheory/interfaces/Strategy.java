package org.gametheory.interfaces;

import org.gametheory.enums.Action;

public interface Strategy {
    boolean shouldChangeAction(boolean exploited, Action lastAction);
    Action switchAction(Action action);
}
