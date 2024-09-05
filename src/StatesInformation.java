import javax.swing.*;
import java.awt.*;

public class StatesInformation extends JFrame {
    private JPanel panelMain;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JList<String> list;
    private JScrollPane scrollPane;

    public StatesInformation() {
        setTitle("State Query");
        InitializeComponents();
        ConfigureComponents();
        SetupLayout();
        FinalizeSetup();
    }

    private void InitializeComponents() {
        a1Button = new RoundedButton("1");
        a2Button = new RoundedButton("2");
        a3Button = new RoundedButton("3");
        panelMain = new JPanel(new BorderLayout());

        // Initialize the JList and JScrollPane
        list = new JList<>(new String[] {"Item 1", "Item 2", "Item 3"});
        scrollPane = new JScrollPane(list);
    }

    private void ConfigureComponents() {
        Font buttonFont = new Font("Consolas", Font.PLAIN, 36);
        Font listFont = new Font("Consolas", Font.PLAIN, 24); // Larger font for the list
        Color buttonBackground = new Color(0x8044e4);
        Color buttonForeground = Color.WHITE;
        Color listBackground = new Color(0x181424);
        Color listForeground = Color.WHITE;

        a1Button.setFont(buttonFont);
        a2Button.setFont(buttonFont);
        a3Button.setFont(buttonFont);

        a1Button.setBackground(buttonBackground);
        a1Button.setForeground(buttonForeground);
        a2Button.setBackground(buttonBackground);
        a2Button.setForeground(buttonForeground);
        a3Button.setBackground(buttonBackground);
        a3Button.setForeground(buttonForeground);

        panelMain.setBackground(new Color(0x181424));

        list.setBackground(listBackground);
        list.setForeground(listForeground);
        list.setFont(listFont); // Set the font for the list
        list.setCellRenderer(new CenteredListCellRenderer()); // Apply custom renderer
    }

    private void SetupLayout() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
        buttonPanel.setBackground(new Color(0x181424));
        buttonPanel.add(a1Button);
        buttonPanel.add(a2Button);
        buttonPanel.add(a3Button);

        // Add button panel to the top (NORTH) of the main panel
        panelMain.add(buttonPanel, BorderLayout.NORTH);

        // Create a panel to center the scroll pane
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(0x181424));
        listPanel.add(Box.createVerticalGlue()); // Filler to center content
        listPanel.add(scrollPane);
        listPanel.add(Box.createVerticalGlue()); // Filler to center content

        // Limit the size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(300, 200)); // Adjust as needed

        // Add list panel to the center of the main panel
        panelMain.add(listPanel, BorderLayout.CENTER);

        setContentPane(panelMain);
    }

    private void FinalizeSetup() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StatesInformation::new);
    }

    // Custom renderer to center text in the list
    private static class CenteredListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text
            }
            return component;
        }
    }
}
