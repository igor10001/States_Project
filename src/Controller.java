import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private StatesInformationView view;

    public Controller(Model model, StatesInformationView view) {
        this.model = model;
        this.view = view;

        // Initialize the view with data from the model
        view.setListData(model.getItems());

        // Add action listeners to buttons
        view.getA1Button().addActionListener(new ButtonClickListener("1", "Informații despre state care au depășit numărul specificat de populație"));
        view.getA2Button().addActionListener(new ButtonClickListener("2", "Informații despre state de pe un anumit continent dat"));
        view.getA3Button().addActionListener(new ButtonClickListener("3", "O listă de state pentru limba oficială dată"));
    }

    private class ButtonClickListener implements ActionListener {
        private String item;
        private String description;

        public ButtonClickListener(String item, String description) {
            this.item = item;
            this.description = description;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getInputField().requestFocus(); // Focus the input field
            view.getDescriptionLabel().setText(description); // Set the description
            model.addItem(item);
            view.setVisibleInputField();
            view.setListData(model.getItems());
        }
    }
}
