import java.awt.*;
import java.awt.image.BufferedImage;

public class Bishop extends Pieces {
    Graphics g;
    public Bishop(Board board,int column , int row,boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.position_x = column * board.spotSize;
        this.position_y = row * board.spotSize;
        this.isWhite = isWhite;
        this.pieceName ="bishop";
        this.pieceImage = piecesImage.getSubimage(2*piecesImageScale , isWhite? 0 : piecesImageScale,piecesImageScale,piecesImageScale ).getScaledInstance(board.spotSize,board.spotSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row) {
        return(Math.abs(this.column - col) == Math.abs(this.row - row) && Math.abs(this.column - col) <= 3 )|| (Math.abs(this.column - col) == 1 && Math.abs(this.row - row) == 0);

    }
}

