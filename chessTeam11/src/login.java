import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class login implements ActionListener {
    JLabel login = new JLabel("Login");
    JLabel usernameL = new JLabel("Username :");
    JLabel userPasswordL = new JLabel("Password :");
    JLabel message = new JLabel();
    JFrame frame = new JFrame();
    JTextField usernameF = new JTextField();
    JPasswordField userPasswordF = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JLabel newAccount = new JLabel("A new player ?");

    JButton signUpButton = new JButton("SIGNUP");

    usernamesAndPasswords newUser = new usernamesAndPasswords();
    public login(){

        frame.setTitle("Chess login page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700,550);
        frame.setLocationRelativeTo((Component) null);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());

        login.setBounds(310,60,140,140);
        login.setForeground(new Color(157,200,218));
        login.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        frame.add(login);

        usernameL.setBounds(177,155,100,100);
        usernameL.setForeground(Color.white);
        usernameL.setFont(new Font("",Font.BOLD,15));
        userPasswordL.setBounds(177,205,100,100);
        userPasswordL.setForeground(Color.white);
        userPasswordL.setFont(new Font("",Font.BOLD,15));
        frame.add(usernameL);
        frame.add(userPasswordL);


        usernameF.setBounds(272,197,210,21);
        usernameF.setBackground(new Color(213,225,235));
        userPasswordF.setBounds(272,247,210,21);
        userPasswordF.setBackground(new Color(213,225,235));
        frame.add(usernameF);
        frame.add(userPasswordF);


        loginButton.setBounds(272,295,80,25);
        loginButton.setFont(new Font("Comic sans",Font.BOLD,12));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(new Color(157,200,218));
        loginButton.addActionListener(this);
        frame.add(loginButton);

        frame.add(message);

        signUpButton.setBounds(365,295,80,25);
        signUpButton.setFont(new Font("Comic sans",Font.BOLD,12));
        signUpButton.setForeground(Color.white);
        signUpButton.setBackground(new Color(157,200,218));
        signUpButton.addActionListener(this);
        frame.add(signUpButton);

        ImageIcon background = new ImageIcon("background2.png");
        background.setImage(background.getImage().getScaledInstance(700, 550, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 700, 550);
        frame.add(back);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){
        if (e.getSource()==loginButton){
            boolean matched = false;
            String line;
            String username = usernameF.getText();
            String password = String.valueOf(userPasswordF.getPassword());

            try {
                FileReader readFile = new FileReader("login.txt");
                BufferedReader BR = new BufferedReader(readFile);
                while ((line = BR.readLine())!=null){
                    if (line.equals(username+ "\t" +password)){
                        matched = true;
                        break;
                    }
                }
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            if (matched) {
                new FirstPage();
                frame.dispose();
            }
            else {
                message.setBounds(266,340,250,25);
                message.setForeground(Color.white);
                message.setFont(new Font("",Font.BOLD,12));
                message.setText("Invalid username or password");

            }
        }
        else if (e.getSource()== signUpButton){
            new signUpWindow();
            frame.dispose();
        }
    }
}
