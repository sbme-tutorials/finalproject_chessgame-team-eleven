import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class startGame implements ActionListener {

    JFrame frame = new JFrame();
    RoundedButton whiteButton1;
    RoundedButton blackButton1;
    RoundedButton whiteButton2;
    RoundedButton blackButton2;
    RoundedButton startGame;
    RoundedTextField firstPlayer;
    RoundedTextField secondPlayer;
    RoundedTextField setTimer;

    public String name1;
    public String name2;
    public String time;
    public String colorPlayer1;
    public String colorPlayer2;
    RoundButton start;
    public startGame(){
        frame.setTitle("Start game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700,585);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());


        start = new RoundButton("Start",20,new Color(33, 106, 134),new Color(255, 255, 255));
        start.setFont(new Font("MV Boli",Font.BOLD,20));
        start.setBounds(490,358 ,90,30);
        start.setHorizontalAlignment(SwingConstants.CENTER);
        start.setVerticalAlignment(SwingConstants.CENTER);
        start.addActionListener(this);
        frame.add(start);

        JLabel player1=new JLabel("Player 1",JLabel.CENTER);
        player1.setFont(new Font("",Font.BOLD,35));
        player1.setForeground(Color.white);
        player1.setBounds(-25,-65,300,224);
        frame.add(player1);


        JLabel playAs1=new JLabel("Play as : ",JLabel.CENTER);
        playAs1.setFont(new Font("",Font.BOLD,25));
        playAs1.setForeground(Color.white);
        playAs1.setBounds(300,80,200,124);
        frame.add(playAs1);

        JLabel player2=new JLabel("Player 2",JLabel.CENTER);
        player2.setFont(new Font("",Font.BOLD,35));
        player2.setForeground(Color.white);
        player2.setBounds(-25,85,300,224);
        frame.add(player2);

        JLabel playAs2=new JLabel("Play as : ",JLabel.CENTER);
        playAs2.setFont(new Font("",Font.BOLD,25));
        playAs2.setForeground(Color.white);
        playAs2.setBounds(300,230,200,124);
        frame.add(playAs2);

        JLabel timer=new JLabel("Timer : ",JLabel.CENTER);
        timer.setFont(new Font("",Font.BOLD,27));
        timer.setForeground(Color.white);
        timer.setBounds(-42,255,300,224);
        frame.add(timer);


        ImageIcon white=new ImageIcon("whiteking2.png");
        ImageIcon black=new ImageIcon("blackKing.png");
        ImageIcon startgameimg=new ImageIcon("startgame.png");


        whiteButton1=new RoundedButton("",white.getImage());
        whiteButton1.setText("");
        whiteButton1.setBounds(430, 100, 132, 100);
        whiteButton1.addActionListener(this);
        frame.add(whiteButton1);


        blackButton1=new RoundedButton("",black.getImage());
        blackButton1.setText("");
        blackButton1.setBounds(500, 103, 132, 80);
        blackButton1.addActionListener(this);
        frame.add(blackButton1);

        whiteButton2=new RoundedButton("",white.getImage());
        whiteButton2.setText("");
        whiteButton2.setBounds(530, 250, 132, 80);
        whiteButton2.addActionListener((ActionListener) this);
        frame.add(whiteButton2);

        blackButton2=new RoundedButton("",black.getImage());
        blackButton2.setText("");
        blackButton2.setBounds(410, 250, 132, 100);
        blackButton2.addActionListener(this);
        frame.add(blackButton2);


        startGame=new RoundedButton("",startgameimg.getImage());
        startGame.setBounds(440,260,200,100);
        startGame.addActionListener(this);
        //frame.add(startGame);

        firstPlayer=new RoundedTextField(1);
        firstPlayer.setBounds(45,90,230,35);
        firstPlayer.setFont(new Font("",Font.BOLD,10));
        firstPlayer.setForeground(Color.black);
        firstPlayer.setBackground(Color.white);
        firstPlayer.setCaretColor(Color.black);
        frame.add(firstPlayer);

        secondPlayer =new RoundedTextField(1);
        secondPlayer.setBounds(45,235,230,35);
        secondPlayer.setFont(new Font("",Font.BOLD,10));
        secondPlayer.setForeground(Color.black);
        secondPlayer.setBackground(Color.white);
        secondPlayer.setCaretColor(Color.black);

        frame.add(secondPlayer);

        setTimer=new RoundedTextField(1);
        setTimer.setBounds(160,355,110,32);
        setTimer.setFont(new Font("",Font.BOLD,10));
        setTimer.setForeground(Color.black);
        setTimer.setBackground(Color.white);
        setTimer.setCaretColor(Color.black);

        frame.add(setTimer);


        ImageIcon bottomimage= new ImageIcon("secondpage.png");
        JLabel bottom=new JLabel("",bottomimage,JLabel.CENTER);
        bottom.setBounds(330,660,500,300);
        frame.add(bottom);

        ImageIcon background = new ImageIcon("New Project.png");
        background.setImage(background.getImage().getScaledInstance(700, 550, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 800, 650);
        frame.add(back);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==blackButton1){
            colorPlayer1="black";
            colorPlayer2="white";
        }
        if(e.getSource()==whiteButton1){
            colorPlayer1="white";
            colorPlayer2="black";
        }
        if(e.getSource()==blackButton2){
            colorPlayer1="white";
            colorPlayer2="black";
        }
        if(e.getSource()==whiteButton2){
            colorPlayer1="black";
            colorPlayer2="white";
        }
        if(e.getSource()== start){
            name1 = firstPlayer.getText();
            name2 = secondPlayer.getText();
            time = setTimer.getText();
            new GameFrame(name1,name2,colorPlayer1,colorPlayer2,time);
            frame.dispose();

        }
    }
}
