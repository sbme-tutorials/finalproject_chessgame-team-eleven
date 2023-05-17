
import javax.swing.*;
import java.awt.*;

public class RoundedTextField extends JTextField {

    public RoundedTextField(int columns) {
        super(columns);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50);
        super.paintComponent(g);
        g2.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JTextField textField = new RoundedTextField(10);
        textField.setPreferredSize(new Dimension(200, 30));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(textField);

        frame.add(panel);
        frame.setVisible(true);
    }
}

