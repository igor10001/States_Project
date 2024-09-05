import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            StatesInformationView view = new StatesInformationView();
            new Controller(model, view);
        });
    }
}
