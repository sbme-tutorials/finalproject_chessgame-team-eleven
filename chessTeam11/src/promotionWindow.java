import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class promotionWindow implements ActionListener {
    String replacingPawnTo;
    RoundedTextField replacing = new RoundedTextField(1);
    JFrame framePromoting;
    JLabel promotion ;
    JButton promote = new JButton("Promote");
    Board board;
    Move move;
    public promotionWindow(Board board, Move move){
        this.board = board;
        this.move = move;
        framePromoting = new JFrame();
        // JFrame frame = new JFrame();
        promotion = new JLabel("Replacing Pawn to: ");

        framePromoting.setTitle("Pawn Promotion");
        framePromoting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePromoting.setResizable(false);
        framePromoting.setSize(400,250);
        framePromoting.setVisible(true);
        ImageIcon icon = new ImageIcon("promotion.jpg");
        framePromoting.setIconImage(icon.getImage());

        promotion.setBounds(15,-40,190,190);
        promotion.setForeground(Color.white);
        promotion.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        framePromoting.add(promotion);

        replacing.setBounds(15,80,200,30);
        replacing.addActionListener(this);
        framePromoting.add(replacing);

        promote.setBounds(100,140,75,25);
        promote.setFont(new Font("Comic sans MS",Font.BOLD,10));
        promote.setForeground(Color.white);
        promote.setBackground(new Color(100,160,200));
        promote.addActionListener(this);
        framePromoting.add(promote);


        ImageIcon background = new ImageIcon("pawnBG.jpg");
        background.setImage(background.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 700, 550);
        framePromoting.add(back);
        framePromoting.setVisible(true);

    }

    public boolean pawnCanBePromoted(){

        if( move.promotedPawn != null) {
            board.pieceList.remove( move.promotedPawn);

            switch (replacingPawnTo){
                case "queen" :{
                    if ( move.promotedPawn.isWhite) {
                        board.pieceList.add(new Queen(board, move.newColumn, 0, true));
                    }
                    else
                        board.pieceList.add(new Queen(board, move.newColumn,7,false));
                }
                break;
                case "bishop" :{
                    if ( move.promotedPawn.isWhite) {
                        board.pieceList.add(new Bishop(board, move.newColumn, 0, true));
                    }
                    else
                        board.pieceList.add(new Bishop(board, move.newColumn,7,false));
                    break;
                }

                case "rook":{
                    if ( move.promotedPawn.isWhite)
                        board.pieceList.add(new Rook(board, move.newColumn,0,true));
                    else
                        board.pieceList.add(new Rook(board, move.newColumn,7,false));
                }
                break;
                case "knight":{
                    if (move.promotedPawn.isWhite)
                        board.pieceList.add(new Knight(board, move.newColumn,0,true));
                    else
                        board.pieceList.add(new Knight(board, move.newColumn,7,false));
                }
                break;
            }
            board.repaint();
            return true;
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == promote) {
            this.replacingPawnTo =replacing.getText();
            pawnCanBePromoted();
            framePromoting.dispose();
        }}

}