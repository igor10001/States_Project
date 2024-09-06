import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Controller {
    private Model model;
    private StatesInformationView view;
    private StateDataManager dataManager;

    public Controller(Model model, StatesInformationView view) {
        this.model = model;
        this.view = view;
        this.dataManager = new StateDataManager();

        // Initialize with existing data
        view.setListData(model.getItems());

        // Add action listeners
        view.getA1Button().addActionListener(new ButtonClickListener());
        view.getA2Button().addActionListener(new ButtonClickListener());
        view.getA3Button().addActionListener(new ButtonClickListener());
        view.getConfirmButton().addActionListener(new ConfirmButtonClickListener());
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "1":
                    handlePopulationQuery();
                    break;
                case "2":
                    handleContinentQuery();
                    break;
                case "3":
                    handleLanguageQuery();
                    break;
            }
        }

        private void handlePopulationQuery() {
            String input = JOptionPane.showInputDialog(view, "Enter minimum population:");
            try {
                long minPopulation = Long.parseLong(input);
                List<State> filteredStates = dataManager.getStates().stream()
                        .filter(state -> state.getPopulation() > minPopulation)
                        .collect(Collectors.toList());

                model.getItems().clear();
                for (State state : filteredStates) {
                    model.addItem(state.getName());
                }

                view.setListData(model.getItems());
                view.getDescriptionLabel().setText("States with population greater than " + minPopulation);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Invalid population number. Please enter a valid number.");
            }
        }

        private void handleContinentQuery() {
            String input = JOptionPane.showInputDialog(view, "Enter continent:");
            List<State> filteredStates = dataManager.getStates().stream()
                    .filter(state -> state.getContinent().equalsIgnoreCase(input))
                    .collect(Collectors.toList());

            model.getItems().clear();
            for (State state : filteredStates) {
                model.addItem(state.getName());
            }

            view.setListData(model.getItems());
            view.getDescriptionLabel().setText("States on the continent: " + input);
        }

        private void handleLanguageQuery() {
            String input = JOptionPane.showInputDialog(view, "Enter official language:");
            List<State> filteredStates = dataManager.getStates().stream()
                    .filter(state -> state.getOfficialLanguage().equalsIgnoreCase(input))
                    .collect(Collectors.toList());

            model.getItems().clear();
            for (State state : filteredStates) {
                model.addItem(state.getName());
            }

            view.setListData(model.getItems());
            view.getDescriptionLabel().setText("States with official language: " + input);
        }
    }

    private class ConfirmButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle confirmation logic here
            // Example logic to process selected item
            // System.out.println("Confirmed: " + selectedItem);
            // You may want to clear the input field or perform other actions
        }
    }
}
