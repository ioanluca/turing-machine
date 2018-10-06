package machine.transition;

import machine.State;

public class Transition {

    private final State state;
    private final Character symbol;
    private final Operation action;

    public Transition(State state, Character symbol, Operation action) {
        this.state = state;
        this.symbol = symbol;
        this.action = action;
    }

    public State getState() {
        return state;
    }

    public Character getSymbol() {
        return symbol;
    }

    public Operation getAction() {
        return action;
    }
}
