import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StatesInformationView extends JFrame {
    private RoundedButton a1Button;
    private RoundedButton a2Button;
    private RoundedButton a3Button;
    private JList<String> list;
    private JScrollPane scrollPane;
    private JLabel descriptionLabel;

    public StatesInformationView() {
        setTitle("State Query");
        initializeComponents();
        configureComponents();
        setupLayout();
        finalizeSetup();
    }

    private void initializeComponents() {
        a1Button = new RoundedButton("1", "1");
        a2Button = new RoundedButton("2", "2");
        a3Button = new RoundedButton("3", "3");
        list = new JList<>();
        scrollPane = new JScrollPane(list);
        descriptionLabel = new JLabel();
    }

    private void configureComponents() {
        Font buttonFont = new Font("Consolas", Font.PLAIN, 36);
        Font listFont = new Font("Consolas", Font.PLAIN, 24);
        Font descriptionFont = new Font("Consolas", Font.PLAIN, 24);
        Color buttonBackground = new Color(0x8044e4);
        Color buttonForeground = Color.WHITE;
        Color listBackground = new Color(0x181424);
        Color listForeground = Color.WHITE;
        Color descriptionBackground = new Color(0x181424);
        Color descriptionForeground = Color.WHITE;

        a1Button.setFont(buttonFont);
        a2Button.setFont(buttonFont);
        a3Button.setFont(buttonFont);

        a1Button.setBackground(buttonBackground);
        a1Button.setForeground(buttonForeground);
        a2Button.setBackground(buttonBackground);
        a2Button.setForeground(buttonForeground);
        a3Button.setBackground(buttonBackground);
        a3Button.setForeground(buttonForeground);

        list.setBackground(listBackground);
        list.setForeground(listForeground);
        list.setFont(listFont);

        descriptionLabel.setFont(descriptionFont);
        descriptionLabel.setForeground(descriptionForeground);
        descriptionLabel.setBackground(descriptionBackground);
        descriptionLabel.setOpaque(true);
    }

    private void setupLayout() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
        buttonPanel.setBackground(new Color(0x181424));
        buttonPanel.add(a1Button);
        buttonPanel.add(a2Button);
        buttonPanel.add(a3Button);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBackground(new Color(0x181424));
        descriptionPanel.add(descriptionLabel);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(0x181424));
        listPanel.add(scrollPane);

        scrollPane.setPreferredSize(new Dimension(300, 300));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(0x181424));
        centerPanel.add(descriptionPanel, BorderLayout.NORTH);
        centerPanel.add(listPanel, BorderLayout.CENTER);

        JPanel confirmButtonPanel = new JPanel();
        confirmButtonPanel.setBackground(new Color(0x181424));

        JPanel panelMain = new JPanel(new BorderLayout());
        panelMain.setBackground(new Color(0x181424));
        panelMain.add(buttonPanel, BorderLayout.NORTH);
        panelMain.add(centerPanel, BorderLayout.CENTER);
        panelMain.add(confirmButtonPanel, BorderLayout.SOUTH);

        setContentPane(panelMain);
    }

    private void finalizeSetup() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setVisible(true);
    }

    public RoundedButton getA1Button() {
        return a1Button;
    }

    public RoundedButton getA2Button() {
        return a2Button;
    }

    public RoundedButton getA3Button() {
        return a3Button;
    }


    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public void setListData(List<String> data) {
        list.setListData(data.toArray(new String[0]));
    }
}
