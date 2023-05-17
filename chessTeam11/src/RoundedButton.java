import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private Image backgroundImage;

    public RoundedButton(String label, Image backgroundImage) {
        super(label);
        this.backgroundImage = backgroundImage;
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RoundRectangle2D roundRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 50, 50);
        g2.clip(roundRectangle);
        g2.drawImage(backgroundImage, 0, 0, null);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint the border
    }


}
