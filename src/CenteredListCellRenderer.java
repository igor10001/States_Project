import javax.swing.*;
import java.awt.*;

public class CenteredListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return component;
    }
}
