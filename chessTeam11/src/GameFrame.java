import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    public  static Timer timer;
    static int  player1Time ;
    static int player2Time ;
    static int delay=1000;
    static JLabel blackKilledLabel;
    static JLabel whiteKilledLabel;
    static JFrame frame;

    static String name1;
    static String name2;

    public String name1B;
    public String name2B;
    public String time;

    static String colorPlayer1;
    static String colorPlayer2;
    private String determineName;
    private int convertedTimer;
    public GameFrame(String name1, String name2, String colorPlayer1, String colorPlayer2, String time){

        this.name1 = name1;
        this.name2 = name2;
        this.colorPlayer1 = colorPlayer1;
        this.colorPlayer2 = colorPlayer2;
        this.time = time;

        name1B = name1;
        name2B = name2;

        convertedTimer = convertTimer(time);
        player1Time = convertedTimer;
        player2Time = convertedTimer;

        if (colorPlayer1 == "white"){
            determineName = name1;
            name1 = name2;
            name2 = determineName;

            name1B = name1;
            name2B = name2;
        }

        frame  = new JFrame();

        //set the panel to put the white killed pieces on it
        JPanel whiteKilledPanel = new JPanel();
        whiteKilledPanel.setPreferredSize(new Dimension(120, 350));
        whiteKilledPanel.setBackground( new Color(6, 43, 61));
        whiteKilledPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,200));

        whiteKilledLabel = new JLabel();
        whiteKilledLabel.setPreferredSize(new Dimension(120, 350));
        whiteKilledLabel.setLayout(new GridLayout(8,2));
        whiteKilledPanel.add(whiteKilledLabel);

        // set the panel to add the black killed pieces on it
        JPanel blackKilledPanel = new JPanel();
        blackKilledPanel.setPreferredSize(new Dimension(120, 350));
        blackKilledPanel.setBackground(new Color(14, 104, 141, 255));
        blackKilledPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10,200));

        blackKilledLabel = new JLabel();
        blackKilledLabel.setPreferredSize(new Dimension(120, 350));
        blackKilledLabel.setLayout(new GridLayout(8,2));
        blackKilledPanel.add(blackKilledLabel);

        //add background to the frame
        ImageIcon BackgroundImage = new ImageIcon("backgroundb.jpg");
        Image img = BackgroundImage.getImage();
        Image temp_img = img.getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
        BackgroundImage = new ImageIcon(temp_img);
        JLabel BackGround = new JLabel();
        BackGround.setIcon(BackgroundImage);
        BackGround.setBounds(0, 0, 1000, 800);
        frame.add(BackGround);

        //create a panel to add class board on it
        JPanel backgroundOfBoard = new JPanel();
        backgroundOfBoard.setLayout( new GridBagLayout());
        backgroundOfBoard.setBounds(200, 150, 600, 600);
        backgroundOfBoard.setBackground(new Color(139, 135, 141));

        //set frame characteristics
        ImageIcon image = new ImageIcon("frame icon.jpg");
        frame.setIconImage(image.getImage());
        frame.setMinimumSize(new Dimension(1000, 800));
        frame.setLocationRelativeTo((Component) null);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setTitle("Team Eleven Chess engine");
        frame.pack();

        //create two labels for player1/2 to show beside the board
        ImageIcon imageForPlayer_1 = new ImageIcon("player 2.png");
        Image img1 = imageForPlayer_1.getImage();
        Image temp_img1 = img1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        imageForPlayer_1 = new ImageIcon(temp_img1);
        JLabel player_1 = new JLabel();
        player_1.setText(name1);
        player_1.setIcon(imageForPlayer_1);
        player_1.setBounds(60, 40, 180, 130);
        player_1.setHorizontalTextPosition(JLabel.CENTER);
        player_1.setVerticalTextPosition(JLabel.BOTTOM);
        player_1.setForeground(new Color(0xFFFFFFFF));
        player_1.setFont(new Font("MV Boli", Font.PLAIN, 29));

        ImageIcon imageForPlayer_2 = new ImageIcon("player 1.png");
        Image img2 = imageForPlayer_2.getImage();
        Image temp_img2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        imageForPlayer_2 = new ImageIcon(temp_img2);
        JLabel player_2 = new JLabel();
        player_2.setBounds(850, 40, 180, 130);
        player_2.setText(name2);
        player_2.setIcon(imageForPlayer_2);
        player_2.setHorizontalTextPosition(JLabel.CENTER);
        player_2.setVerticalTextPosition(JLabel.BOTTOM);
        player_2.setForeground(new Color(0xFFFFFFFF));
        player_2.setFont(new Font("MV Boli", Font.PLAIN, 29));

        //create a label to add timer contents to it
        JLabel backgroundOfTimer1=new JLabel("",null,JLabel.CENTER);
        backgroundOfTimer1.setBounds(210,40,200,100);
        backgroundOfTimer1.setLayout(new GridLayout(2,1));

        JLabel backgroundOfTimer2=new JLabel("",null,JLabel.CENTER);
        backgroundOfTimer2.setBounds(580,60,200,100);
        backgroundOfTimer2.setLayout(new GridLayout(2,1));

        //create the timer
        JLabel player1Label = new JLabel(name1 + " :   " + player1Time);
        player1Label.setFont(new Font("MV Boli",Font.BOLD,18));
        player1Label.setForeground(new Color(0xFFFFFF));
        backgroundOfTimer1.add(player1Label);

        RoundButton player1Button = new RoundButton(name1, 20, new Color(121, 160, 176), new Color(0xD01A356C));
        player1Button.setFont(new Font("MV Boli",Font.BOLD,25));
        player1Button.setFocusable(false);
        player1Button.setEnabled(false);
        backgroundOfTimer1.add(player1Button);

        RoundButton player2Button = new RoundButton(name2, 20, new Color(121, 160, 176), new Color(0xD01A356C));
        player2Button.setFont(new Font("MV Boli",Font.BOLD,25));
        player2Button.setFocusable(false);
        backgroundOfTimer2.add(player2Button);

        JLabel player2Label = new JLabel(name2 + " :   " + player2Time );
        player2Label.setFont(new Font("MV Boli",Font.BOLD,18));
        player2Label.setForeground(new Color(0xFFFFFF));
        backgroundOfTimer2.add(player2Label);

        player2Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to player 1
                player2Button.setEnabled(false);
                player1Button.setEnabled(true);

                // Update player 2's time and label
                player2Time -= delay / 1000;
                player2Label.setText(name2B +" :  " +  player2Time);

                // Restart the timer
                timer.restart();
            }
        });

        player1Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to player 2
                player1Button.setEnabled(false);
                player2Button.setEnabled(true);

                // Update player 1's time and label
                player1Time -= delay / 1000;
                player1Label.setText( name1B +" :  " +  player1Time);

                // Restart the timer
                timer.restart();
            }
        });

        timer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check for time-out conditions
                if (player1Time == 0) {
                    new gameOverTime(name2B,name1B);
                    timer.stop();
                    frame.dispose();
                } else if (player2Time == 0) {
                    new gameOverTime(name1B,name2B);
                    timer.stop();
                    frame.dispose();
                }

                // Update the label for the active player
                if (player1Button.isEnabled()) {
                    player1Time -= delay / 1000;
                    player1Label.setText( name1B +" :  " +  player1Time);
                } else {
                    player2Time -= delay / 1000;
                    player2Label.setText( name2B +" :  " +  player2Time);
                }
            }
        });

        Board board = new Board();

        //create a panel that hold the white, black killed panels and the chess board panels
        JPanel mainPanel = new JPanel();;
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(whiteKilledPanel,BorderLayout.EAST);
        mainPanel.add(board,BorderLayout.CENTER);
        mainPanel.add(blackKilledPanel,BorderLayout.WEST);

        frame.pack();
        frame.add(mainPanel);

        BackGround.add(backgroundOfBoard);
        BackGround.add(backgroundOfTimer1);
        BackGround.add(backgroundOfTimer2);
        backgroundOfBoard.add(board);
        BackGround.add(player_1);
        BackGround.add(player_2);

        frame.setVisible(true);

    }
    public int convertTimer (String time){
        return Integer.parseInt(time);
    }
}

