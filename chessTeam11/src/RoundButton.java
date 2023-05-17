import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {
    private Color backgroundColor;
    private Color foregroundColor;
    private int radius;

    public RoundButton(String text, int radius, Color backgroundColor, Color foregroundColor) {
        super(text);
        this.backgroundColor = backgroundColor;
        setBorder(BorderFactory.createLineBorder(getBackground(), 0));
        this.foregroundColor = foregroundColor;
        this.radius = radius;

        setBorderPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.setColor(foregroundColor);
        g2.drawString(getText(), getWidth() / 2 - g2.getFontMetrics().stringWidth(getText()) / 2, (getHeight() /2) + g2.getFontMetrics().getAscent()/2  - g2.getFontMetrics().getDescent());
        g2.dispose();
    }}
