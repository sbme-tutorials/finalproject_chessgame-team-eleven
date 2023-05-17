import java.awt.image.BufferedImage;

public class Rook extends Pieces {
    public Rook(Board board,int column , int row,boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.position_x = column * board.spotSize;
        this.position_y = row * board.spotSize;
        this.isWhite = isWhite;
        this.pieceName ="rook";
        this.pieceImage = piecesImage.getSubimage(4*piecesImageScale , isWhite? 0 : piecesImageScale,piecesImageScale,piecesImageScale ).getScaledInstance(board.spotSize,board.spotSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col,int row){
        return this.column==col||this.row==row;
    }
    public boolean moveCollidesWithPiece(int col,int row){
        //left
        if (this.column>col)
            for (int c =this.column-1; c >col ; c--)
                if (board.getPiece(c,this.row)!=null)
                    return true;
        //right
        if (this.column<col)
            for (int c =this.column+1; c <col ; c++)
                if (board.getPiece(c,this.row)!=null)
                    return true;
        //up
        if (this.row>row)
            for (int r =this.row-1; r >row ; r--)
                if (board.getPiece(this.column,r)!=null)
                    return true;
        //down
        if (this.row<row)
            for (int r =this.row+1; r <row ; r++)
                if (board.getPiece(this.column,r)!=null)
                    return true;


        return false;
    }

}
