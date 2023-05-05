package cs3500.marblesolitaire.model.hw04;


/**
 * Class that represents Triangles Solitaire Model. A Triangles Solitaire Model has a dimension
 * and empty slot position.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  public TriangleSolitaireModel() throws IllegalArgumentException {
    super(5, 0, 0);
  }

  public TriangleSolitaireModel(int dimensions) throws IllegalArgumentException {
    super(dimensions, 0, 0);
  }

  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(5, sRow, sCol);
  }

  public TriangleSolitaireModel(int dimensions, int sRow, int sCol)
          throws IllegalArgumentException {
    super(dimensions, sRow, sCol);
  }


  /**
   * Method that determines if a Triangles Solitaire game is over.
   *
   * @return true is the game is over, or false if it is not.
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.getSlotAt(i, j).equals(SlotState.Marble)) {
          if (this.validMove(i, j, i, j - 2)
                  || this.validMove(i, j, i, j + 2)
                  || this.validMove(i, j, i - 2, j - 2)
                  || this.validMove(i, j, i - 2, j)
                  || this.validMove(i, j, i + 2, j)
                  || this.validMove(i, j, i + 2, j + 2)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Method that determines the size of a Triangles Solitaire board.
   *
   * @return the integer size of the board.
   */
  @Override
  public int getBoardSize() {
    return this.length;
  }

  /**
   * Methods that determines if a given slot of a Triangles Solitaire board is invalid.
   *
   * @param row position of the given slot.
   * @param col position of the given slot.
   * @return true if slot is invalid, or false if it is not.
   */
  @Override
  public boolean isInvalid(int row, int col) {
    return (col > row);
  }

  @Override
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    return ((!(isOutOfBounds(fromRow, fromCol) && isOutOfBounds(toRow, toCol)))
            && (this.getSlotAt(fromRow, fromCol).equals(SlotState.Marble))
            && (this.getSlotAt(toRow, toCol).equals(SlotState.Empty))
            && (this.getSlotAt((fromRow + toRow) / 2,
            (fromCol + toCol) / 2).equals(SlotState.Marble))
            && ((fromRow == toRow && (Math.abs(fromCol - toCol) == 2))
            || (fromRow - 2 == toRow && (fromCol - 2 == toCol || fromCol == toCol))
            || (fromRow + 2 == toRow && (fromCol + 2 == toCol || fromCol == toCol))));
  }
}
