import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class FirstPage extends JFrame implements ActionListener {
    RoundedButton newgamebutton;
    RoundedButton instructions;
    RoundedButton Score;

    RoundedButton exitTheGame;

    FirstPage() {
        ImageIcon gameicon = new ImageIcon("602719ef-10b9-499d-9268-16a63e67ec8c-removebg-preview.png");
        this.setSize(700, 587);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo((Component) null);
        this.setTitle("Chess Game");
        this.setResizable(false);
        this.setIconImage(gameicon.getImage());


        ImageIcon background_image = new ImageIcon("background.jpg");
        Image image = background_image.getImage();
        Image temp = image.getScaledInstance(700, 587, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 700, 550);


        ImageIcon chessimage = new ImageIcon("cheسss.png");
        JLabel chessword = new JLabel("", chessimage, JLabel.CENTER);
        chessword.setBounds(1, -220, 700, 550);
        this.add(chessword);

        ImageIcon newgame = new ImageIcon("newgame.png");
        ImageIcon score = new ImageIcon("score.png");
        ImageIcon resume = new ImageIcon("resume.png");
        ImageIcon exit = new ImageIcon("Exit.png");

        Score = new RoundedButton("", score.getImage());
        Score.setBounds(80, 210, 204, 144);
        Score.addActionListener(this);

        newgamebutton = new RoundedButton("", newgame.getImage());
        newgamebutton.setBounds(70, 100, 366, 130);
        newgamebutton.addActionListener(this);

        instructions = new RoundedButton("", resume.getImage());
        instructions.setBounds(354, 215, 432, 151);
        instructions.addActionListener(this);

        exitTheGame = new RoundedButton("", exit.getImage());
        exitTheGame.setBounds(335, 115, 372, 170);
        exitTheGame.addActionListener(this);

        this.add(newgamebutton);
        this.add(instructions);
        this.add(Score);
        this.add(exitTheGame);
        this.add(background);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newgamebutton) {
            new startGame();
            this.dispose();
        }

        else if (e.getSource()== exitTheGame){
            this.dispose();
        }

        else if (e.getSource()== instructions){
            new instructions();
            this.dispose();
        }

        else if (e.getSource()==Score){
          new score();
          this.dispose();
        }

    }
}
