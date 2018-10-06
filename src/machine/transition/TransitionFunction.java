package machine.transition;

import machine.State;
import machine.TapeAlphabetSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransitionFunction {

    private final List<State> states;
    private final TapeAlphabetSet tapeAlphabet;
    private final Operation right;
    private final Operation left;

    List<String> values = new ArrayList<>();

    Map<State, Map<Character, Transition>> map = new HashMap<>();

    public TransitionFunction(List<State> states, TapeAlphabetSet tapeAlphabet, Operation right, Operation left) {
        this.states = states;
        this.tapeAlphabet = tapeAlphabet;
        this.right = right;
        this.left = left;
    }


    public TransitionFunction define(String state1, char symbol, String state2, Character replacementSymbol, Operation operation) {

        State currentState = new State(state1);
        State nextState = new State(state2);

        Map<Character, Transition> hashMap = new HashMap<>();
        hashMap.put(symbol, new Transition(nextState, replacementSymbol, operation));

        map.put(currentState, hashMap);

        return this;
    }

    public Transition input(State state, char symbol) {
        Map<Character, Transition> result = map.get(state);
        final String message = "Undefined state δ(" + state + ", " + symbol + ")";

        if (result != null) {

            Transition transition = result.getOrDefault(symbol, null);

            if (transition != null) return transition;
        }

        System.out.println(message);
        return null;
    }
}

