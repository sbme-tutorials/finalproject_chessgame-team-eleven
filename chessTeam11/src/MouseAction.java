import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAction extends MouseAdapter {
    boolean isDraggingOwnPiece = false;

    static Board board;
    KingCheck checkScanner;
    King whiteKing ;
    King blackKing;
    Pieces wking;
    Pieces bking ;
    boolean wKingCheck = false;
    boolean bKingCheck = false;
    boolean wKingCannotEscape = false;
    boolean bKingCannotEscape = false;

    public MouseAction(Board board){
        this.board = board;
        checkScanner = new KingCheck(board);
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int column = e.getX()/ board.spotSize;
        int row = e.getY()/ board.spotSize;
        Pieces piece = board.getPiece(column,row);
        if(piece != null){
            board.selectedPiece = piece;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        wking=board.findKing(true);
        bking=board.findKing(false);
        if(board.selectedPiece != null) {
            boolean isPlayer1Turn = Board.moveCounter % 2 != 0;
            if (isPlayer1Turn) {
                if (board.selectedPiece.isWhite == true) {
                    isDraggingOwnPiece = true;
                    if (checkScanner.isKingChecked(new Move(board, board.selectedPiece, board.selectedPiece.column, board.selectedPiece.row))) {
                        wKingCheck = true;
                    }
                         whiteKing = new King(board, wking.column, wking.row, true);
                        if (!whiteKing.hasEscapeMoves()) {
                            wKingCannotEscape = true;
                        }
                        else{
                        wKingCannotEscape = false;
                        }
                }
            }
            else if (board.selectedPiece.isWhite == false) {
                    isDraggingOwnPiece = true;
                    if (checkScanner.isKingChecked(new Move(board, board.selectedPiece, board.selectedPiece.column, board.selectedPiece.row))) {
                        bKingCheck = true;
                    }
                    blackKing = new King(board, bking.column, bking.row, false);
                    if (!blackKing.hasEscapeMoves()) {
                            bKingCannotEscape = true;
                        }
                    else {
                         bKingCannotEscape = false;
                    }

            }
                if (isDraggingOwnPiece) {
                    board.selectedPiece.position_x = e.getX() - board.spotSize / 2;
                    board.selectedPiece.position_y = e.getY() - board.spotSize / 2;
                    board.repaint();
                }
            }
        }

    @Override
    public void mouseReleased(MouseEvent e) {
        int  column = e.getX()/ board.spotSize;
        int row = e.getY()/ board.spotSize;
            if(isDraggingOwnPiece){
            Move move = new Move(board, board.selectedPiece ,column,row);
                if(board.isValidMove(move)){
                    board.makeMove(move);
            }else {
                    board.selectedPiece.position_x = board.selectedPiece.column * board.spotSize;
                    board.selectedPiece.position_y = board.selectedPiece.row * board.spotSize;
        }
        board.selectedPiece = null;
        board.repaint();
        if(wKingCheck && wKingCannotEscape){
           if(GameFrame.colorPlayer1 == "black") {
              new gameOver(GameFrame.name1,GameFrame.name2);
           }
           else{
               new gameOver(GameFrame.name2,GameFrame.name1);
           }
           GameFrame.frame.dispose();
        }
        else if (bKingCheck && bKingCannotEscape){
            if(GameFrame.colorPlayer1 == "white") {
               new gameOver(GameFrame.name1,GameFrame.name2);
            }
            else {
                new gameOver(GameFrame.name2,GameFrame.name1);
            }
            GameFrame.frame.dispose();
        }
        wKingCheck=false;
        bKingCheck=false;
        isDraggingOwnPiece=false;
        bKingCannotEscape = false;
        wKingCannotEscape = false;
        }
    }
}



