import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<String> items;

    public Model() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}
