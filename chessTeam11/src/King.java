import java.awt.image.BufferedImage;

public class King extends Pieces {
   KingCheck checkScanner = new KingCheck(board);

    public King(Board board,int column , int row,boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.position_x = column * board.spotSize;
        this.position_y = row * board.spotSize;
        this.isWhite = isWhite;
        this.pieceName ="king";
        this.pieceImage = piecesImage.getSubimage(0*piecesImageScale , isWhite? 0 : piecesImageScale,piecesImageScale,piecesImageScale ).getScaledInstance(board.spotSize,board.spotSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col,int row) {

        return Math.abs((col-this.column)*(row-this.row))==1 || Math.abs(col-this.column)+Math.abs(row-this.row)==1||canCastle(col,row);

    }

    public boolean canCastle(int col,int row) {
        if (this.row == row) {
            if (col == 6) {
                Pieces rook = board.getPiece(7, row);
                if (rook != null && rook.isFirstMove && isFirstMove) {
                    return board.getPiece(5, row) == null &&
                            board.getPiece(6, row) == null &&
                            !board.checkScanner.isKingChecked(new Move(board, this, 5, row));

                }
            } else if (col == 2) {
                Pieces rook = board.getPiece(0, row);
                if (rook != null && rook.isFirstMove && isFirstMove) {
                    return board.getPiece(3, row) == null &&
                            board.getPiece(2, row) == null &&
                            board.getPiece(1, row) == null &&
                            !board.checkScanner.isKingChecked(new Move(board, this, 3, row));

                }
            }


        }
        return false;
}
  public boolean hasEscapeMoves() {
       Pieces King = board.findKing(board.selectedPiece.isWhite);
   //  boolean canKingEscape = false;
      boolean canPiecesBlockCheck = false;

      // if (Board.moveCounter % 2 != 0) {
      for (Pieces piece : Board.pieceList) {
         // System.out.println(piece);
          if (piece.isWhite == board.selectedPiece.isWhite) {
              for (int column = 0 ; column < 7 ; column++) {
                  for (int row = 0 ; row < 7 ; row++) {
                    Move move = new Move(board, piece, column, row);
                      if(board.getPiece(column,row)!= null && board.getPiece(column,row).pieceName=="king")
                          continue;
                      if (piece.isValidMove(move)){
                          //System.out.println(piece);
                          //System.out.println("column" + column);
                          //System.out.println("row" + row);
                          canPiecesBlockCheck = true;
                          break;
                      }
                  }if (canPiecesBlockCheck)
                      break;
          }
      }if (canPiecesBlockCheck)
              break;
    }

      if (canPiecesBlockCheck) {
          return true;
      } else return false;
    }}
          /*for(int column= 0 ;column<=8;column++){
             for(int row = 0 ;row <=8 ; row++){
                 if (wking.isValidMove(new Move(board,wking,column,row))) {
                     canKingEscape=true;
                     break;
                 }
             }if(canKingEscape)
                 break;
         }*/

      //}
    /* if (Board.moveCounter % 2 == 0) {
              for (Pieces piece : Board.pieceList) {
                  if (piece.isWhite == false) {
                      for(int column= 0 ;column<=8;column++){
                          for(int row = 0 ;row <=8 ; row++){
                              if (piece.isValidMove(new Move(board,piece,column,row))) {
                                  canPiecesBlockCheck=true;
                                  break;
                              }
                          }if(canPiecesBlockCheck)
                              break;

                      }
                  }
              }/*for(int column= 0 ;column<=8;column++){
             for(int row = 0 ;row <=8 ; row++){
                 if (bking.isValidMove(new Move(board,bking,column,row))) {
                     canKingEscape=true;
                     break;
                 }
             }if(canKingEscape)
                 break;
         }

     }*/




       /* if((!(board.checkScanner.isKingChecked(new Move(board, this, this.column, this.row + 1) ) &&
              board.checkScanner.isKingChecked(new Move(board, this, this.column, this.row - 1)) &&
              board.checkScanner.isKingChecked(new Move(board, this, this.column + 1, this.row)) &&
              board.checkScanner.isKingChecked(new Move(board, this, this.column - 1, this.row)) &&
              board.checkScanner.isKingChecked(new Move(board, this, this.column - 1, this.row - 1)) &&
              board.checkScanner.isKingChecked(new Move(board, this, this.column + 1, this.row + 1)) &&
              board.checkScanner.isKingChecked(new Move(board, this, this.column - 1, this.row + 1)) &&
              board.checkScanner.isKingChecked(new Move(board, this, this.column + 1, this.row - 1))))){
              canKingEscape=true;
       // return true;
      }*/
        /*  if (canKingEscape|| canPiecesBlockCheck){
              return true;
          }else return false;*/

      //  return false;




