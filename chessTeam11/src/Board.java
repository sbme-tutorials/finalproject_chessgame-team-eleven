
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel{
  static   int checkcounter=0;
   static ArrayList<Pieces> pieceList = new ArrayList<>();
    static int moveCounter = 1;
    int column = 8;
    int row = 8;
    public int spotSize = 75;
    public Pieces selectedPiece;
    public KingCheck checkScanner = new KingCheck(this);
    MouseAction mouseAction = new MouseAction(this);

    public Board(){

        this.setPreferredSize(new Dimension(row*spotSize , column*spotSize));
        this.addMouseListener(mouseAction);
        this.addMouseMotionListener(mouseAction);
        addPieces();

    }

    //method to see if there is a piece in a specific row and column and return it if exists
    public Pieces getPiece( int column , int row){
        for(Pieces piece : pieceList){
            if(piece.column == column && piece.row == row){
                return piece;
            }
        }
        return null;
    }

    //method to check if the move is valid depending on the  piece color and the available rows and columns
    public boolean isValidMove(Move move){
        checkScanner=new KingCheck(this);
        if (sameColor(move.selectedPiece, move.killedPieces)) {
            return false;
            }
        if (!(move.selectedPiece.isValidMovement(move.newColumn, move.newRow))) {
            return false;
        }
        if(move.selectedPiece.moveCollidesWithPiece(move.newColumn, move.newRow)){
            return false;
        }
        if(checkScanner.isKingChecked(move)){
            return false;
        }//else System.out.println("the king is safe");
        if(move.newColumn < 0 || move.newColumn > 8 || move.newRow < 0 || move.newRow > 7){
            return false;
        }
        return true;
    }

    public boolean isValidMove1(Move move) {

        if (!(move.selectedPiece.isValidMovement(move.newColumn, move.newRow))) {
            return false;
        }
        if(move.selectedPiece.moveCollidesWithPiece(move.newColumn, move.newRow)){
            return false;
        }

        return true;
    }

    private void moveKing(Move move){
        if(Math.abs(move.selectedPiece.column - move.newColumn)==2){
            Pieces rook;
            if(move.selectedPiece.column < move.newColumn){
                rook=getPiece(7,move.selectedPiece.row);
                rook.column=5;

            }else{
                rook=getPiece(0,move.selectedPiece.row);
                rook.column=3;
            }
            rook.position_x=rook.column*spotSize;
        }}

    //method to make the move if it is valid and kill the piece that was on that spot if there was any
    public void makeMove(Move move){
        if(move.selectedPiece.pieceName.equals("king")) {
            moveKing(move);
        }
        move.selectedPiece.column = move.newColumn;
        move.selectedPiece.row = move.newRow;
        move.selectedPiece.position_x = move.newColumn * spotSize;
        move.selectedPiece.position_y = move.newRow * spotSize;
        move.selectedPiece.isFirstMove = false;


        if(moveCounter % 2 != 0){
            moveCounter++;
            System.out.println("white plays");
        }else {
            moveCounter++;
            System.out.println("black plays");
        }

        if ((selectedPiece.isWhite &&  move.newRow == 0) || (!selectedPiece.isWhite && move.newRow == 7)) {
            if (selectedPiece.pieceName == "pawn") {
                move.promotedPawn = selectedPiece;
                System.out.println("pawn is Promoted");
               promotionWindow promotionWindow = new promotionWindow(this, move);
            }
        }
        kill(move);
        }

      //method to remove the killed pieces from the chess board and add it to their corresponding panels
    public void kill(Move move){

        if (move.killedPieces != null) {
            if (move.killedPieces.isWhite) {
               System.out.println(move.killedPieces.pieceName);
                    switch(move.killedPieces.pieceName){
                        case "knight" : {
                    ImageIcon whiteKnight = new ImageIcon("White Knight.png");
                    Image img = whiteKnight.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);;
                    JLabel WhiteKnight = new JLabel(new ImageIcon(img));
                    GameFrame.whiteKilledLabel.add(WhiteKnight);
                    GameFrame.frame.setVisible(true);
                    break;
                }
                        case "queen" : {
                    ImageIcon whiteQueen = new ImageIcon("White Queen.png");
                    Image img = whiteQueen.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel WhiteQueen = new JLabel(new ImageIcon(img));
                    GameFrame.whiteKilledLabel.add(WhiteQueen);
                    GameFrame.frame.setVisible(true);
                            break;
                }
                        case  "rook" : {
                    ImageIcon whiteRook = new ImageIcon("White Rook.png");
                    Image img = whiteRook.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel WhiteRook = new JLabel(new ImageIcon(img));
                    GameFrame.whiteKilledLabel.add(WhiteRook);
                    GameFrame.frame.setVisible(true);
                    break;
                }
                        case "pawn": {
                  ImageIcon whitePawn = new ImageIcon("White Pawn.png");
                  Image img = whitePawn.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                  JLabel WhitePawn = new JLabel(new ImageIcon(img));
                  GameFrame.whiteKilledLabel.add(WhitePawn);
                  GameFrame.frame.setVisible(true);
                  break;
                }
                        case "bishop" : {
                    ImageIcon whiteBishop = new ImageIcon("White Bishop.png");
                    Image img = whiteBishop.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel WhiteBishop = new JLabel(new ImageIcon(img));
                    GameFrame.whiteKilledLabel.add(WhiteBishop);
                    GameFrame.frame.setVisible(true);
                    break;
                }

            }} else {
                System.out.println(move.killedPieces.pieceName);
                switch ( move.killedPieces.pieceName ) {
                    case "knight" : {
                    ImageIcon blackKnight = new ImageIcon("Black Knight.png");
                    Image img = blackKnight.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);;
                    JLabel BlackKnight = new JLabel(new ImageIcon(img));
                    GameFrame.blackKilledLabel.add(BlackKnight);
                    GameFrame.frame.setVisible(true);
                    break;
                }
                    case "queen" : {
                    ImageIcon blackQueen = new ImageIcon("Black Queen.png");
                    Image img = blackQueen.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);;
                    JLabel BlackQueen = new JLabel(new ImageIcon(img));
                    GameFrame.blackKilledLabel.add(BlackQueen);
                    GameFrame.frame.setVisible(true);
                    break;
                }
                    case "rook" : {
                    ImageIcon blackRook = new ImageIcon("Black Rook.png");
                    Image img = blackRook.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);;
                    JLabel BlackRook = new JLabel(new ImageIcon(img));
                    GameFrame.blackKilledLabel.add(BlackRook);
                    GameFrame.frame.setVisible(true);
                    break;
                }
                    case "pawn" : {
                    ImageIcon blackPawn = new ImageIcon("Black Pawn.png");
                    Image img = blackPawn.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel BlackPawn = new JLabel(new ImageIcon(img));
                    GameFrame.blackKilledLabel.add(BlackPawn);
                    GameFrame.frame.setVisible(true);
                    break;
                }
                    case "bishop" : {
                    ImageIcon blackBishop = new ImageIcon("Black Bishop.png");
                    Image img = blackBishop.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel BlackBishop = new JLabel(new ImageIcon(img));
                    GameFrame.blackKilledLabel.add(BlackBishop);
                    GameFrame.frame.setVisible(true);
                    break;
                }
            }}}
        pieceList.remove(move.killedPieces);

    }

    //method to compare the color between the selected piece and the targeted piece
    public boolean sameColor( Pieces p1 , Pieces p2){
        if(p1 == null || p2 == null){
            return false;
        }
        return p1.isWhite == p2.isWhite;
    }



    //method to add the pieces on the chess board
    public void addPieces(){
        pieceList.add(new Queen(this,3,0,false));
        pieceList.add(new Queen(this,3,7,true));

        pieceList.add(new Bishop(this,2,0,false));
        pieceList.add(new Bishop(this,5,0,false));
        pieceList.add(new Bishop(this,2,7,true));
        pieceList.add(new Bishop(this,5,7,true));

        pieceList.add(new Rook(this,0,0,false));
        pieceList.add(new Rook(this,7,0,false));
        pieceList.add(new Rook(this,0,7,true));
        pieceList.add(new Rook(this,7,7,true));

        pieceList.add(new Knight(this,1,0,false));
        pieceList.add(new Knight(this,6,0,false));
        pieceList.add(new Knight(this,1,7,true));
        pieceList.add(new Knight(this,6,7,true));

        pieceList.add(new Pawn(this,0,1,false));
        pieceList.add(new Pawn(this,1,1,false));
        pieceList.add(new Pawn(this,2,1,false));
        pieceList.add(new Pawn(this,3,1,false));
        pieceList.add(new Pawn(this,4,1,false));
        pieceList.add(new Pawn(this,5,1,false));
        pieceList.add(new Pawn(this,6,1,false));
        pieceList.add(new Pawn(this,7,1,false));
        pieceList.add(new Pawn(this,0,6,true));
        pieceList.add(new Pawn(this,1,6,true));
        pieceList.add(new Pawn(this,2,6,true));
        pieceList.add(new Pawn(this,3,6,true));
        pieceList.add(new Pawn(this,4,6,true));
        pieceList.add(new Pawn(this,5,6,true));
        pieceList.add(new Pawn(this,6,6,true));
        pieceList.add(new Pawn(this,7,6,true));

        pieceList.add(new King(this,4,7,true));
        pieceList.add(new King(this,4,0,false));

    }

    Pieces findKing(boolean isWhite){
        for(Pieces piece:pieceList){
            if( piece.isWhite == isWhite && piece.pieceName.equals("king")){
                return piece;
            }
        }
        return null;
    }

    public boolean isKingInCheck(boolean isWhiteKing) {
        Pieces king = this.findKing(isWhiteKing);
        if (king == null) {
            return false;
        }
        int kingCol = king.column;
        int kingRow = king.row;
        KingCheck kingCheck = new KingCheck(this);
        Move move = new Move(this, king, kingCol, kingRow);
        return kingCheck.isKingChecked(move);
    }
     public boolean canBlockCheck(){

        for(Pieces piece : pieceList){
          for (int c = 0; c < row+1; c++) {
              for (int r = 0; r < column + 1; r++) {
                  Move move =new Move(this, piece, piece.column, piece.row);
                  if (isValidMove(new Move(this, piece, c, r))) {
                     System.out.println(piece);
                      checkcounter++;
                     System.out.println(checkcounter);
                      if (checkcounter != 0) {
                          return true;}

                  }

}}}


          return false;
    }

              //method to paint the board and the pieces
              public void paintComponent (Graphics g){
                  Graphics2D g2d = (Graphics2D) g;

                  for (int row = 0; row < 8; row++) {
                      for (int col = 0; col < 8; col++) {
                          g2d.setColor((row + col) % 2 == 0 ? new Color(255, 252, 252) : new Color(149, 149, 175));
                          g2d.fillRect(row * spotSize, col * spotSize, spotSize, spotSize);
                      }
                      if (selectedPiece != null) {
                          checkcounter = 0;
                          for (int c = 0; c < row + 1; c++) {
                              for (int r = 0; r < column + 1; r++) {
                                  if (isValidMove(new Move(this, selectedPiece, c, r))) {
                                      checkcounter++;
                                      System.out.println(checkcounter);
                                      g2d.setColor(new Color(108, 227, 150, 255));
                                      g2d.fillRect(c * spotSize, r * spotSize, spotSize, spotSize - 1);
                                  }
                                  if (isValidMove(new Move(this, selectedPiece, c, r)) && this.getPiece(c, r) != null) {
                                     // checkcounter++;
                                      //System.out.println(checkcounter);
                                      g2d.setColor(new Color(71, 211, 111, 255));
                                      g2d.fillRect(c * spotSize, r * spotSize, spotSize, spotSize - 1);
                                  }
                                  if (isValidMove1(new Move(this, selectedPiece, c, r)) && this.getPiece(c, r) != null && selectedPiece.isWhite == getPiece(c, r).isWhite && !(selectedPiece.row == r && selectedPiece.column == c)) {
                                      g2d.setColor(new Color(248, 97, 97, 179));
                                      g2d.fillRect(c * spotSize, r * spotSize, spotSize, spotSize - 1);

                                  }
                                  if (selectedPiece.row == r && selectedPiece.column == c) {
                                      g2d.setColor(new Color(250, 237, 235, 179));
                                      g2d.fillRect(c * spotSize, r * spotSize, spotSize, spotSize);
                                  }
                                  if (this.getPiece(c, r) == this.findKing(selectedPiece.isWhite) && this.isKingInCheck(getPiece(c, r).isWhite)) {
                                      g2d.setColor(new Color(224, 78, 78, 179));
                                      g2d.fillOval(c * spotSize, r * spotSize, spotSize, spotSize);
                                  }

                              }

                          }
                      }
                  }

                  for (Pieces piece : pieceList) {
                      piece.paint(g2d);
                  }
              }}

