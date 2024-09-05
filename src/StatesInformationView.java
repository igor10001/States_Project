import javax.swing.*;
import java.awt.*;
import java.util.List;


public class StatesInformationView extends JFrame {
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JList<String> list;
    private JScrollPane scrollPane;

    public StatesInformationView() {
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
        list = new JList<>();
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

        list.setBackground(listBackground);
        list.setForeground(listForeground);
        list.setFont(listFont);
        list.setCellRenderer(new CenteredListCellRenderer());
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

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(0x181424));
        listPanel.add(Box.createVerticalGlue());
        listPanel.add(scrollPane);
        listPanel.add(Box.createVerticalGlue());

        scrollPane.setPreferredSize(new Dimension(300, 200)); // Adjust as needed

        panelMain.add(listPanel, BorderLayout.CENTER);

        setContentPane(panelMain);
    }

    private void FinalizeSetup() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setVisible(true);
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
}
