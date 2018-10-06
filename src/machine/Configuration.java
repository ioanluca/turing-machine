package machine;

import machine.transition.Operation;
import machine.transition.Transition;

class Configuration {

    private final String tape;
    private final int headLocation;
    private final State state;

    public Configuration(String tape, int headLocation, State state) {
        this.tape = tape + ' ';
        this.headLocation = headLocation;
        this.state = state;
    }

    public State getCurrentState() {
        return state;
    }

    public char getCurrentSymbol() {
        return tape.charAt(headLocation);
    }

    public int getHeadLocation() {
        return headLocation;
    }

    public Configuration getNextConfiguration(Transition transition) {
        State nextState = transition.getState();
        Operation operation = transition.getAction();
        char symbol = transition.getSymbol();

        // Replace char
        char[] nextTape = tape.toCharArray();
        nextTape[headLocation] = symbol;

        int headLocation = this.headLocation;

        switch (operation) {
            case LEFT:
                if (headLocation > 0) headLocation--;
                break;
            case RIGHT:
                headLocation++;
                break;
        }

        String nType = String.valueOf(nextTape);
        if (headLocation != ' ') nType += ' ';


        return new Configuration(nType, headLocation, nextState);
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "tape='" + tape + '\'' +
                ", headLocation=" + headLocation +
                ", state=" + state +
                '}';
    }
}
