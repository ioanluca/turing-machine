import machine.State;
import machine.TapeAlphabetSet;
import machine.transition.TransitionFunction;
import machine.TuringMachine;

import java.util.ArrayList;
import java.util.List;

import static machine.transition.Operation.LEFT;
import static machine.transition.Operation.RIGHT;

public class Main {

    public static void main(String[] args) {
        State startState = new State("q1");
        State acceptState = new State("q_accept");
        State rejectState = new State("q_reject");

        TapeAlphabetSet tapeAlphabet = new TapeAlphabetSet(new char[]{'a','b'});

        List<State> states = new ArrayList<>();
        TransitionFunction tf = new TransitionFunction(states, tapeAlphabet, RIGHT, LEFT)
                                            .define("q1", '0', "q2", ' ', LEFT);
//                                            .define("q2", '0');

        TuringMachine tm = new TuringMachine("0000", tf, startState, acceptState, rejectState);
        tm.run(1000);
    }
}
