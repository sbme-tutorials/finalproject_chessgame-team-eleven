import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class instructions implements ActionListener {
    JFrame frame = new JFrame();
    RoundedButton back;

    public instructions(){
        frame.setTitle("Instructions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700,580);
        frame.setLocationRelativeTo((Component) null);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());

        ImageIcon backBG = new ImageIcon("sahmF.png");
        back =new RoundedButton("",backBG.getImage());
        back.setText("");
        back.setBounds(-13, -13, 500, 700);
        back.addActionListener(this);
        frame.add(back);

        ImageIcon background = new ImageIcon("instructionsF.png");
        background.setImage(background.getImage().getScaledInstance(700, 550, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 942, 651);
        frame.add(back);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            new FirstPage();
            frame.dispose();
        }

    }
}
