import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Pieces {
    Move move;
    int position_x;
    int position_y;
    int row;
    int column;
    boolean isWhite;
    String pieceName;
    Image pieceImage;
    Board board;
    protected boolean isFirstMove = true;

    BufferedImage piecesImage;

    {
        try {
            piecesImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("resources/" + "image.png"));
        } catch (IOException e) {
            e.getStackTrace();
            e.printStackTrace();
        }
    }

    protected int piecesImageScale = piecesImage.getWidth() / 6;

    public Pieces(Board board) {
        this.board = board;
    }

    public boolean isValidMovement(int col, int row){
        return true;
    }
    public boolean moveCollidesWithPiece(int col,int row) {
        return false;

    }
    public boolean isValidMove(Move move){

       KingCheck checkScanner=new KingCheck(board);
       for (int column = 0 ; column < 7 ; column++) {
            for (int row = 0 ; row < 7 ; row++) {
               if(board.getPiece(column,row)!= null && board.getPiece(column,row).pieceName=="king")
                    continue;
        if (checkScanner.isKingChecked(move) ){
            return false;
        }//else System.out.println("he feels no check");
            }}
       if (!(move.selectedPiece.isValidMovement(move.newColumn, move.newRow))) {
            return false;
        }
        if(move.selectedPiece.moveCollidesWithPiece(move.newColumn, move.newRow)){
            return false;
        }
        if (board.sameColor(move.selectedPiece, move.killedPieces)) {
            return false;
        }
       if(move.newColumn < 0 || move.newColumn > 8 || move.newRow < 0 || move.newRow > 7){
            return false;
        }
        return true;
    }
    public void paint(Graphics2D g2d) {
        g2d.drawImage(pieceImage, position_x, position_y, null);


}
}
