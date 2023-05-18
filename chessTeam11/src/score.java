import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class score implements ActionListener {


   Map<String,Integer > playersData = new HashMap<>();


    JFrame frame = new JFrame();
    JLabel player1;
    JLabel player2;
    JLabel player3 ;
    JLabel player4 ;
    JLabel score1 ;
    JLabel score2 ;
    JLabel score3 ;
    JLabel score4 ;
    JButton backButton = new JButton("Back");


    public score(){
        playersData=new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("playersData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    playersData.put(name, score);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read from file: " + e.getMessage());
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(playersData.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("playersData.txt"))) {
            for (Map.Entry<String, Integer> entry : list) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
        }
        frame.setTitle("Chess game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700,550);
        frame.setLocationRelativeTo((Component) null);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("logo.jpg");
        frame.setIconImage(icon.getImage());


        player1 = new JLabel("-");
        score1 = new JLabel("0");
        player2 = new JLabel("-");
        score2 = new JLabel("0");
        player3 = new JLabel("-");
        score3 = new JLabel("0");
        player4 = new JLabel("-");
        score4 = new JLabel("0");

        int i=1;

        for(Map.Entry<String,Integer> e: list){
            if(i==1){
                player1 = new JLabel(e.getKey());
                score1 = new JLabel(String.valueOf(e.getValue()));
            }
            else if(i==2){
                player2 = new JLabel(e.getKey());
                score2 = new JLabel(String.valueOf(e.getValue()));
            }
            else if(i==3){
                player3 = new JLabel(e.getKey());
                score3 = new JLabel(String.valueOf(e.getValue()));
            }
            else if(i==4){
                player4 = new JLabel(e.getKey());
                score4 = new JLabel(String.valueOf(e.getValue()));
            }
            i++;
        }


        player1.setBounds(295,275,170,100);
        player1.setForeground(Color.white);
        player1.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player1);

        score1.setBounds(303,305,170,100);
        score1.setForeground(Color.white);
        score1.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score1);

        player2.setBounds(140,255,170,100);
        player2.setForeground(Color.white);
        player2.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player2);

        score2.setBounds(160,285,170,100);
        score2.setForeground(Color.white);
        score2.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score2);

        player3.setBounds(445,255,170,100);
        player3.setForeground(Color.white);
        player3.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player3);

        score3.setBounds(455,285,170,100);
        score3.setForeground(Color.white);
        score3.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score3);

        player4.setBounds(110,345,170,100);
        player4.setForeground(Color.white);
        player4.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player4);

        score4.setBounds(110,377,170,100);
        score4.setForeground(Color.white);
        score4.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score4);

        backButton.setBounds(300,460,75,25);
        backButton.setFont(new Font("Comic sans",Font.BOLD,12));
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(72,133,174));
        backButton.addActionListener(this);
        frame.add(backButton);


        ImageIcon background = new ImageIcon("score2.png");
        background.setImage(background.getImage().getScaledInstance(700, 550, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 700, 550);
        frame.add(back);
        frame.setVisible(true);
    }
    public score (String player1Name,String player2Name,boolean firstplayerwon){


        playersData=new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("playersData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    playersData.put(name, score);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read from file: " + e.getMessage());
        }

        if(firstplayerwon){
            if (playersData.containsKey(player1Name)) {
                playersData.put(player1Name, playersData.get(player1Name) + 100);
            } else {
                playersData.put(player1Name, 100);
            }
            if (playersData.containsKey(player2Name)) {
                playersData.put(player2Name, playersData.get(player2Name));
            } else {
                playersData.put(player2Name, 0);

            }
        }
        else{
            if (playersData.containsKey(player2Name)) {
                playersData.put(player2Name, playersData.get(player2Name) + 100);
            } else {
                playersData.put(player2Name, 100);
            }
            if (playersData.containsKey(player1Name)) {
                playersData.put(player1Name, playersData.get(player1Name));
            } else {
                playersData.put(player1Name, 0);

            }
        }


       List<Map.Entry<String, Integer>> list = new ArrayList<>(playersData.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("playersData.txt"))) {
            for (Map.Entry<String, Integer> entry : list) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
        }
        frame.setTitle("Chess game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700,550);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("logo.jpg");
        frame.setIconImage(icon.getImage());


        player1 = new JLabel("-");
        score1 = new JLabel("0");
        player2 = new JLabel("-");
        score2 = new JLabel("0");
        player3 = new JLabel("-");
        score3 = new JLabel("0");
        player4 = new JLabel("-");
        score4 = new JLabel("0");

        int i=1;

        for(Map.Entry<String,Integer> e: list){
            if(i==1){
                player1 = new JLabel(e.getKey());
                score1 = new JLabel(String.valueOf(e.getValue()));
            }
            else if(i==2){
                player2 = new JLabel(e.getKey());
                score2 = new JLabel(String.valueOf(e.getValue()));
            }
            else if(i==3){
                player3 = new JLabel(e.getKey());
                score3 = new JLabel(String.valueOf(e.getValue()));
            }
            else if(i==4){
                player4 = new JLabel(e.getKey());
                score4 = new JLabel(String.valueOf(e.getValue()));
            }
            i++;
        }


        player1.setBounds(295,275,170,100);
        player1.setForeground(Color.white);
        player1.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player1);

        score1.setBounds(303,305,170,100);
        score1.setForeground(Color.white);
        score1.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score1);

        player2.setBounds(140,255,170,100);
        player2.setForeground(Color.white);
        player2.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player2);

        score2.setBounds(160,285,170,100);
        score2.setForeground(Color.white);
        score2.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score2);

        player3.setBounds(445,255,170,100);
        player3.setForeground(Color.white);
        player3.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player3);

        score3.setBounds(455,285,170,100);
        score3.setForeground(Color.white);
        score3.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score3);

        player4.setBounds(110,345,170,100);
        player4.setForeground(Color.white);
        player4.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player4);

        score4.setBounds(110,377,170,100);
        score4.setForeground(Color.white);
        score4.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score4);

        backButton.setBounds(300,460,75,25);
        backButton.setFont(new Font("Comic sans",Font.BOLD,12));
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(72,133,174));
        backButton.addActionListener(this);
        frame.add(backButton);

        ImageIcon background = new ImageIcon("score2.png");
        background.setImage(background.getImage().getScaledInstance(700, 550, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 700, 550);
        frame.add(back);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            new FirstPage();
            frame.dispose();
        }
    }
}
