
public class KingCheck {
    Board board;
    Pieces king;
    int kingCol;
    int kingRow;
    KingCheck(Board board){
        this.board=board;
    }
    public  boolean isKingChecked(Move move) {
        king = board.findKing(move.selectedPiece.isWhite);
        assert king != null;
        kingCol = king.column;
        kingRow = king.row;
        if (board.selectedPiece != null && board.selectedPiece.pieceName.equals("king")) {
            kingCol = move.newColumn;
            kingRow = move.newRow;

        }


        return hitByRook(move.newColumn, move.newRow, king, kingCol, kingRow, 0, 1) ||
                hitByRook(move.newColumn, move.newRow, king, kingCol, kingRow, 1, 0) ||
                hitByRook(move.newColumn, move.newRow, king, kingCol, kingRow, 0, -1) ||
                hitByRook(move.newColumn, move.newRow, king, kingCol, kingRow, -1, 0) ||
                hitByBishop(move.newColumn, move.newRow, king, kingCol, kingRow, -1, -1) ||
                hitByBishop(move.newColumn, move.newRow, king, kingCol, kingRow, 1, -1) ||
                hitByBishop(move.newColumn, move.newRow, king, kingCol, kingRow, 1, 1) ||
                hitByBishop(move.newColumn, move.newRow, king, kingCol, kingRow, -1, 1) ||

                hitByََQueen(move.newColumn, move.newRow, king, kingCol, kingRow, -1, -1) ||
                hitByََQueen(move.newColumn, move.newRow, king, kingCol, kingRow, 1, -1) ||
                hitByََQueen(move.newColumn, move.newRow, king, kingCol, kingRow, 1, 1) ||
                hitByََQueen(move.newColumn, move.newRow, king, kingCol, kingRow, -1, 1) ||

                hitByKnight(move.newColumn, move.newRow, king, kingCol, kingRow) ||
                hitByPawn(move.newColumn, move.newRow, king, kingCol, kingRow) ||
                hitByKing(king, kingCol, kingRow)||
                hitByBishopNewMove(king,kingCol,kingRow);

    }


    private boolean hitByBishopNewMove(Pieces king,int kingCol,int kingRow){
        return  checkBishopNewMove(board.getPiece(kingCol-1,kingRow),king)||
                checkBishopNewMove(board.getPiece(kingCol+1,kingRow),king);
    }
    private boolean checkBishopNewMove(Pieces piece,Pieces king ){
        return piece!=null&&!board.sameColor(piece,king)&&piece.pieceName.equals("bishop");

    }
    private boolean hitByRook(int col,int row,Pieces king,int kingCol,int kingRow,int colVal,int rowVal){
        for(int i=1;i<8;i++){

            if(kingCol+(i*colVal)==col &&kingRow+(i*rowVal)==row){

                break;
            }
            Pieces piece=board.getPiece(kingCol+(i*colVal) ,kingRow+(i*rowVal));
            if(piece!=null && piece!=board.selectedPiece){
                if(!board.sameColor(piece,king)&&(piece.pieceName.equals("rook")||piece.pieceName.equals("queen") )){
                    return true;
                }
                break;

            }
        }
        return false;
    }

    private boolean hitByBishop(int col,int row,Pieces king,int kingCol,int kingRow,int colVal,int rowVal){


        for(int i=1;i<4;i++){

            if(kingCol-(i*colVal)==col &&kingRow-(i*rowVal)==row){

                break;
            }
            Pieces piece=board.getPiece(kingCol-(i*colVal) ,kingRow-(i*rowVal));
            if(piece!=null && piece!=board.selectedPiece){
                if(!board.sameColor(piece,king)&&(piece.pieceName.equals("bishop") )){
                    return true;
                }

            }
        }
        return false;
    }
    private boolean hitByََQueen(int col,int row,Pieces king,int kingCol,int kingRow,int colVal,int rowVal){
        for(int i=1;i<8;i++){

            if(kingCol-(i*colVal)==col &&kingRow-(i*rowVal)==row){

                break;
            }
            Pieces piece=board.getPiece(kingCol-(i*colVal) ,kingRow-(i*rowVal));
            if(piece!=null && piece!=board.selectedPiece){
                if(!board.sameColor(piece,king) && piece.pieceName.equals("queen") ){
                    return true;
                }
                break;

            }
        }
        return false;
    }
    private boolean hitByKnight(int col,int row,Pieces king,int kingCol,int kingRow){
        return checkKinght(board.getPiece(kingCol-2,kingRow-3),king,col,row) ||
                checkKinght(board.getPiece(kingCol+2,kingRow-3),king,col,row)||
                checkKinght(board.getPiece(kingCol+3,kingRow-2),king,col,row)||
                checkKinght(board.getPiece(kingCol-3,kingRow+2),king,col,row)||
                checkKinght(board.getPiece(kingCol+3,kingRow+2),king,col,row)||
                checkKinght(board.getPiece(kingCol-2,kingRow+3),king,col,row)||
                checkKinght(board.getPiece(kingCol+2,kingRow+3),king,col,row)||
                checkKinght(board.getPiece(kingCol-3,kingRow-2),king,col,row);
    }
    private boolean checkKinght(Pieces piece,Pieces king ,int col,int row){

        return piece!=null&&!board.sameColor(piece,king)&&piece.pieceName.equals("knight");

    }

    private boolean hitByKing(Pieces king , int kingCol  ,int kingRow){
        return checkKing(board.getPiece(kingCol-1,kingRow-1),king)||
                checkKing(board.getPiece(kingCol+1,kingRow-1),king)||
                checkKing(board.getPiece(kingCol,kingRow-1),king)||
                checkKing(board.getPiece(kingCol-1,kingRow),king)||
                checkKing(board.getPiece(kingCol+1,kingRow),king)||
                checkKing(board.getPiece(kingCol-1,kingRow+1),king)||
                checkKing(board.getPiece(kingCol+1,kingRow+1),king)||
                checkKing(board.getPiece(kingCol,kingRow+1),king);
    }
    private boolean checkKing(Pieces piece,Pieces king ){
        return piece!=null&&!board.sameColor(piece,king)&&piece.pieceName.equals("king");

    }
    public boolean hitByPawn(int col,int row,Pieces king,int kingCol,int kingRow){
        int colorVal=king.isWhite ? -1:1;

        return checkPawn(board.getPiece(kingCol+1,kingRow+colorVal),king,col,row)||
                checkPawn(board.getPiece(kingCol,kingRow+colorVal),king,col,row)||
                checkPawn(board.getPiece(kingCol-1,kingRow+colorVal),king,col,row);

    }
    private boolean checkPawn(Pieces piece,Pieces king,int col,int row){
        return piece!=null && !board.sameColor(piece,king) && piece.pieceName.equals("pawn");
    }


}
