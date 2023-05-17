public class Move{
    int oldColumn;
    int oldRow;
    int newColumn;
    int newRow;
    Pieces selectedPiece;
    Pieces killedPieces;
    static Pieces promotedPawn;



    public Move (Board board , Pieces piece, int newColumn , int newRow) {
        this.selectedPiece = piece;
        this.oldColumn = piece.column;
        this.oldRow = piece.row;
        this.newColumn = newColumn;
        this.newRow = newRow;
        this.killedPieces = board.getPiece(newColumn, newRow);

    }




}
