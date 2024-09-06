import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    private static final int ARC_RADIUS = 50;
    private static final Color BUTTON_COLOR = new Color(0x8044e4);
    private static final Color BUTTON_COLOR_PRESSED = BUTTON_COLOR.darker();

    public RoundedButton(String text, String actionCommand) {
        super(text);
        setActionCommand(actionCommand);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        ButtonModel model = getModel();
        Color backgroundColor = model.isArmed() ? BUTTON_COLOR_PRESSED : BUTTON_COLOR;

        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), ARC_RADIUS, ARC_RADIUS);

        g2d.setColor(Color.WHITE);
        g2d.setFont(getFont());
        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
        g2d.drawString(getText(), x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 100);
    }
}
