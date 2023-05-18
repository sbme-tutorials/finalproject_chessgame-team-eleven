import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameOver implements ActionListener {
    JFrame frame = new JFrame();
    JLabel winnerName = new JLabel();
    JLabel checkMate = new JLabel("king has fallen. CHECKMATE");
    JLabel player1 = new JLabel();
    JLabel player2 = new JLabel();
    JLabel winnerScore = new JLabel("Score +100");
     public String winner;
     public String loser;

    JButton scoreButton = new JButton("Score");

    public gameOver(String winner, String loser){
        this.winner = winner;
        this.loser = loser;

        frame.setTitle("Chess game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700,550);
        frame.setLocationRelativeTo((Component) null);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());


        checkMate.setBounds(200,-30,290,260);
        checkMate.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        checkMate.setForeground(Color.white);
        frame.add(checkMate);

        winnerName.setText( winner + " WINS!" );
        winnerName.setBounds(270,20,300,230);
        winnerName.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        winnerName.setForeground(Color.white);
        frame.add(winnerName);


        player1.setText(loser);
        player1.setBounds(145,230,150,100);
        player1.setForeground(Color.white);
        player1.setFont(new Font("Segoe UI",Font.BOLD,20));
        frame.add(player1);

        player2.setText(winner);
        player2.setBounds(478,230,150,100);
        player2.setForeground(Color.white);
        player2.setFont(new Font("Segoe UI",Font.BOLD,20));
        frame.add(player2);

        winnerScore.setBounds(445,270,140,100);
        winnerScore.setForeground(Color.white);
        winnerScore.setFont(new Font("Segoe UI",Font.BOLD,25));
        frame.add(winnerScore);

        scoreButton.setBounds(300,390,75,25);
        scoreButton.setFont(new Font("Comic sans",Font.BOLD,12));
        scoreButton.setForeground(Color.white);
        scoreButton.setBackground(new Color(72,133,174));
        scoreButton.addActionListener(this);
        frame.add(scoreButton);


        ImageIcon background = new ImageIcon("GOBackground.png");
        background.setImage(background.getImage().getScaledInstance(700, 550, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 700, 550);
        frame.add(back);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==scoreButton){
            new score(winner,loser,true);
            frame.dispose();
        }
    }
}
