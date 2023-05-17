import java.awt.image.BufferedImage;

public class Queen extends Pieces {
    public Queen(Board board,int column , int row,boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.position_x = column * board.spotSize;
        this.position_y = row * board.spotSize;
        this.isWhite = isWhite;
        this.pieceName ="queen";
        this.pieceImage = piecesImage.getSubimage(1*piecesImageScale , isWhite? 0 : piecesImageScale,piecesImageScale,piecesImageScale ).getScaledInstance(board.spotSize,board.spotSize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int col, int row) {
        return Math.abs(this.column - col) == Math.abs(this.row - row) || this.column - col == 0 || this.row - row == 0;
    }

    public boolean moveCollidesWithPiece(int col, int row) {
        int dx = Math.abs(col - this.column);
        int dy = Math.abs(row - this.row);
        int xDir = col > this.column ? 1 : col < this.column ? -1 : 0;
        int yDir = row > this.row ? 1 : row < this.row ? -1 : 0;
        int x = this.column + xDir;
        int y = this.row + yDir;
        while (x != col || y != row) {
            if (board.getPiece(x, y) != null) {
                return true;
            }
            x += xDir;
            y += yDir;
        }
        return false;
    }
}

