
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StatesInformationView extends JFrame {
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton confirmButton; // Added Confirm button
    private JList<String> list;
    private JScrollPane scrollPane;
    private JTextField inputField;
    private JLabel descriptionLabel;

    public StatesInformationView() {
        setTitle("State Query");
        InitializeComponents();
        ConfigureComponents();
        SetupLayout();
        FinalizeSetup();
        AddButtonListeners();
    }

    private void InitializeComponents() {
        a1Button = new RoundedButton("1");
        a2Button = new RoundedButton("2");
        a3Button = new RoundedButton("3");
        confirmButton = new RoundedButton("Confirm"); // Initialize Confirm button
        list = new JList<>();
        scrollPane = new JScrollPane(list);
        inputField = new JTextField(20);
        descriptionLabel = new JLabel();
        inputField.setEditable(false); // Initially non-editable
    }

    private void ConfigureComponents() {
        Font buttonFont = new Font("Consolas", Font.PLAIN, 36);
        Font listFont = new Font("Consolas", Font.PLAIN, 24);
        Font inputFont = new Font("Consolas", Font.PLAIN, 24);
        Color buttonBackground = new Color(0x8044e4);
        Color buttonForeground = Color.WHITE;
        Color listBackground = new Color(0x181424);
        Color listForeground = Color.WHITE;
        Color descriptionBackground = new Color(0x181424);
        Color descriptionForeground = Color.WHITE;

        a1Button.setFont(buttonFont);
        a2Button.setFont(buttonFont);
        a3Button.setFont(buttonFont);
        confirmButton.setFont(buttonFont); // Set the same font for Confirm button

        a1Button.setBackground(buttonBackground);
        a1Button.setForeground(buttonForeground);
        a2Button.setBackground(buttonBackground);
        a2Button.setForeground(buttonForeground);
        a3Button.setBackground(buttonBackground);
        a3Button.setForeground(buttonForeground);
        confirmButton.setBackground(buttonBackground); // Set background and foreground for Confirm button
        confirmButton.setForeground(buttonForeground);

        list.setBackground(listBackground);
        list.setForeground(listForeground);
        list.setFont(listFont);
        list.setCellRenderer(new CenteredListCellRenderer());

        inputField.setFont(inputFont);
        descriptionLabel.setFont(inputFont);
        descriptionLabel.setForeground(descriptionForeground);
        descriptionLabel.setBackground(descriptionBackground);
        descriptionLabel.setOpaque(true);
    }

    private void SetupLayout() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
        buttonPanel.setBackground(new Color(0x181424));
        buttonPanel.add(a1Button);
        buttonPanel.add(a2Button);
        buttonPanel.add(a3Button);

        JPanel panelMain = new JPanel(new BorderLayout());
        panelMain.setBackground(new Color(0x181424));
        panelMain.add(buttonPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0x181424));
        inputPanel.add(inputField);
        inputField.setVisible(false);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBackground(new Color(0x181424));
        descriptionPanel.add(descriptionLabel);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(0x181424));
        listPanel.add(Box.createVerticalGlue());
        listPanel.add(scrollPane);
        listPanel.add(Box.createVerticalGlue());

        scrollPane.setPreferredSize(new Dimension(300, 300));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(0x181424));
        centerPanel.add(descriptionPanel, BorderLayout.NORTH);
        centerPanel.add(inputPanel, BorderLayout.CENTER);
        centerPanel.add(listPanel, BorderLayout.SOUTH);

        // Create the confirm button with the same design
        JButton confirmButton = new RoundedButton("Confirm");
        confirmButton.setFont(new Font("Consolas", Font.PLAIN, 36));
        confirmButton.setBackground(new Color(0x8044e4));
        confirmButton.setForeground(Color.WHITE);

        // Adding the confirm button to a separate panel
        JPanel confirmButtonPanel = new JPanel();
        confirmButtonPanel.setBackground(new Color(0x181424));
        confirmButtonPanel.add(confirmButton);

        // Add the centerPanel and confirmButtonPanel to panelMain
        panelMain.add(centerPanel, BorderLayout.CENTER);
        panelMain.add(confirmButtonPanel, BorderLayout.SOUTH);

        setContentPane(panelMain);
    }

    private void FinalizeSetup() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setVisible(true);
    }

    private void AddButtonListeners() {
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInputFieldActive("Informații despre state care au depășit numărul specificat de populație");
            }
        });

        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInputFieldActive("Informații despre state de pe un anumit continent dat");
            }
        });

        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInputFieldActive("O listă de state pentru limba oficială dată");
            }
        });

        confirmButton.addActionListener(new ActionListener() { // Confirm button action
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Confirm button pressed!");
                // Add your confirm action logic here
            }
        });
    }

    private void setInputFieldActive(String description) {
        inputField.setEditable(true); // Make the input field editable
        inputField.requestFocus(); // Focus on the input field
        descriptionLabel.setText(description); // Update the description label
    }

    public JButton getA1Button() {
        return a1Button;
    }

    public JButton getA2Button() {
        return a2Button;
    }

    public JButton getA3Button() {
        return a3Button;
    }

    public JList<String> getList() {
        return list;
    }

    public void setListData(List<String> data) {
        list.setListData(data.toArray(new String[0]));
    }

    public void setVisibleInputField() {
        inputField.setVisible(true);
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }
}
