import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Pawn extends Pieces {
    public Pawn( Board board,int column , int row,boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.position_x = column * board.spotSize;
        this.position_y = row * board.spotSize;
        this.isWhite = isWhite;
        this.pieceName ="pawn";
        this.pieceImage = piecesImage.getSubimage(5*piecesImageScale , isWhite? 0 : piecesImageScale,piecesImageScale,piecesImageScale ).getScaledInstance(board.spotSize,board.spotSize, BufferedImage.SCALE_SMOOTH);

    }
    public boolean isValidMovement(int col, int row) {
        int colorIndex = isWhite ? 1 : -1;
        //push pawn one square forward
        if (this.column == col && row == this.row - colorIndex && board.getPiece(col, row) == null)
            return true;
        //push pawn two squares forward
        if (isFirstMove && this.column == col && row == this.row - colorIndex * 2 && board.getPiece(col, row) == null && board.getPiece(col, row + colorIndex) == null)
            return true;
        //push pawn captures left
        if (col == this.column - 1 && row == this.row - colorIndex && board.getPiece(col, row) != null)
            return true;
        //push pawn captures right
        if (col == this.column + 1 && row == this.row - colorIndex && board.getPiece(col, row) != null)
            return true;
        //push pawn captures forward
        if (col == this.column&& row == this.row - colorIndex && board.getPiece(col, row) != null)
            return true;


        return false;
    }




}
