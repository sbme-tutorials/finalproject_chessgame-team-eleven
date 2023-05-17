import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class signUpWindow implements ActionListener {

    JLabel welcome = new JLabel("Join the Chess Battle Now!");
    JLabel usernameL = new JLabel("Username :");
    JLabel userPasswordL = new JLabel("Password :");
    JLabel userPasswordL2 = new JLabel("Confirm :");
    JLabel message = new JLabel();

    JFrame frame = new JFrame();
    JTextField usernameF = new JTextField();
    JPasswordField userPasswordF = new JPasswordField();
    JPasswordField userPasswordF2 = new JPasswordField();
    JButton joinButton = new JButton("JOIN");

    public String newUsername;
    public String newPassword;
    public String newPassword2;


    public signUpWindow(){

        frame.setTitle("Chess sign up page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700,550);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());

        welcome.setBounds(210,-35,300,300);
        welcome.setForeground(new Color(157,200,218));
        welcome.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        frame.add(welcome);

        usernameL.setBounds(177,115,100,100);
        usernameL.setForeground(Color.white);
        usernameL.setFont(new Font("",Font.BOLD,15));
        userPasswordL.setBounds(177,165,100,100);
        userPasswordL.setForeground(Color.white);
        userPasswordL.setFont(new Font("",Font.BOLD,15));
        userPasswordL2.setBounds(186,215,100,100);
        userPasswordL2.setForeground(Color.white);
        userPasswordL2.setFont(new Font("",Font.BOLD,15));
        frame.add(usernameL);
        frame.add(userPasswordL);
        frame.add(userPasswordL2);

        usernameF.setBounds(272,157,210,21);
        usernameF.setBackground(new Color(213,225,235));
        userPasswordF.setBounds(272,207,210,21);
        userPasswordF.setBackground(new Color(213,225,235));
        userPasswordF2.setBounds(272,257,210,21);
        userPasswordF2.setBackground(new Color(213,225,235));
        frame.add(usernameF);
        frame.add(userPasswordF);
        frame.add(userPasswordF2);

        frame.add(message);

        joinButton.setBounds(315,310,80,25);
        joinButton.setFont(new Font("Comic sans",Font.BOLD,12));
        joinButton.setForeground(Color.white);
        joinButton.setBackground(new Color(157,200,218));
        joinButton.addActionListener(this);
        frame.add(joinButton);


        ImageIcon background = new ImageIcon("background2.png");
        background.setImage(background.getImage().getScaledInstance(700, 550, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 700, 550);
        frame.add(back);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==joinButton){
            newUsername = usernameF.getText();
            newPassword = String.valueOf(userPasswordF.getPassword());
            newPassword2 = String.valueOf(userPasswordF2.getPassword());
            if (newPassword.equals(newPassword2)){
                try {
                    FileWriter file = new FileWriter("login.txt",true);
                    file.write(newUsername+ "\t" + newPassword + "\n");
                    file.close();
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                new FirstPage();
                frame.dispose();
            }
            else {
                message.setBounds(273,340,180,30);
                message.setForeground(Color.white);
                message.setFont(new Font("",Font.BOLD,13));
                message.setText("passwords do not match");

            }
        }
    }
}
