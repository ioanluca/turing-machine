package machine;

import machine.transition.Transition;
import machine.transition.TransitionFunction;

import java.util.ArrayList;
import java.util.List;

public class TuringMachine {

    private List<Configuration> configurationList;
    private final TransitionFunction tf;
    private final State startState;
    private final State acceptState;
    private final State rejectState;

    public TuringMachine(String input, TransitionFunction tf, State startState, State acceptState, State rejectState) {
        this.tf = tf;
        this.startState = startState;
        this.acceptState = acceptState;
        this.rejectState = rejectState;

        List<State> states = new ArrayList<>();

        this.configurationList = new ArrayList<>();
        this.configurationList.add(new Configuration(input, 0, startState));
    }

    public void run(int milliseconds) {
        final int MAX = 1000;

        for (int i = 0; i < MAX; i++) {
            step();


            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void step() {
        Configuration cf = getCurrentConfiguration();

        Transition transition = tf.input(cf.getCurrentState(), cf.getCurrentSymbol());

        Configuration newCf = cf.getNextConfiguration(transition);

        System.out.println(getCurrentConfiguration());
        this.configurationList.add(newCf);
    }

    public Configuration getCurrentConfiguration() {
        return configurationList.get(configurationList.size()-1);
    }

    public State getAcceptState() {
        return acceptState;
    }

    public State getRejectState() {
        return rejectState;
    }


}
