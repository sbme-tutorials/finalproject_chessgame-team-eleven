import java.awt.image.BufferedImage;

public class Knight extends Pieces {
    public Knight(Board board,int column , int row,boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.position_x = column * board.spotSize;
        this.position_y = row * board.spotSize;
        this.isWhite = isWhite;
        this.pieceName ="knight";
        this.pieceImage = piecesImage.getSubimage(3*piecesImageScale , isWhite? 0 : piecesImageScale,piecesImageScale,piecesImageScale ).getScaledInstance(board.spotSize,board.spotSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col,int row){
        return Math.abs(col-this.column)==2&&Math.abs(row-this.row)==3||Math.abs(col-this.column)==3&&Math.abs(row-this.row)==2;
    }
}

