import java.util.ArrayList;
import java.util.List;

public class StateDataManager {
    private List<State> states;

    public StateDataManager() {
        states = initializeStates();
    }

    private List<State> initializeStates() {
        List<State> states = new ArrayList<>();
        states.add(new State("USA", 331000000, "North America", "English"));
        states.add(new State("China", 1440000000, "Asia", "Chinese"));
        states.add(new State("India", 1390000000, "Asia", "Hindi"));
        states.add(new State("Germany", 83000000, "Europe", "German"));
        states.add(new State("Brazil", 213000000, "South America", "Portuguese"));
        states.add(new State("Australia", 25000000, "Australia", "English"));
        states.add(new State("Nigeria", 211000000, "Africa", "English"));
        states.add(new State("Canada", 38000000, "North America", "English"));
        states.add(new State("France", 67000000, "Europe", "French"));
        // Add more states as necessary
        return states;
    }

    public List<State> getStates() {
        return states;
    }
}
