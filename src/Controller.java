import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private StatesInformationView view;

    public Controller(Model model, StatesInformationView view) {
        this.model = model;
        this.view = view;

        view.setListData(model.getItems());

        view.getA1Button().addActionListener(new ButtonClickListener("1"));
        view.getA2Button().addActionListener(new ButtonClickListener("2"));
        view.getA3Button().addActionListener(new ButtonClickListener("3"));
    }

    private class ButtonClickListener implements ActionListener {
        private String item;

        public ButtonClickListener(String item) {
            this.item = item;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            model.addItem(item);
            view.setListData(model.getItems());
        }
    }
}
