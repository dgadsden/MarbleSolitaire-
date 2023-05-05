package cs3500.marblesolitaire.model.hw04;

/**
 * Class that represents a European Solitaire Model. A European marble solitaire game
 * has side length as well as an empty slot position. A European Marble Solitaire board is
 * similar to an English board, except the corners between the arms of the cross are filled in to
 * produce an octagon shape.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {


  private SlotState[][] board;


  /**
   * Default constructor that set side length at 3 and the empty slot in the middle(3,3).
   */
  public EuropeanSolitaireModel() throws IllegalArgumentException {
    super(3, 3, 3);

  }

  /**
   * Constructor that takes a given side length and has a set empty slot position at the middle of
   * the board.
   *
   * @param sideLength the side length of the Marble Solitaire board.
   */
  public EuropeanSolitaireModel(int sideLength) throws IllegalArgumentException {

    super(sideLength, ((sideLength * 3) - 2) / 2, ((sideLength * 3) - 2) / 2);

  }


  /**
   * Constructor has a set side length that takes in position of empty slot.
   *
   * @param sRow the row position on the Marble Solitaire board.
   * @param sCol the column position on the Marble Solitaire board.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {

    super(3, sRow, sCol);

  }


  /**
   * Constructor that takes a given side length and has a set empty slot position at the middle of
   * the board.
   *
   * @param sideLength the side length of the Marble Solitaire board.
   * @param sRow       the row position on the Marble Solitaire board.
   * @param sCol       the column  position on the Marble Solitaire board.
   */
  public EuropeanSolitaireModel(int sideLength, int sRow, int sCol) {

    super(sideLength, sRow, sCol);


  }


  @Override
  public boolean isInvalid(int row, int col) {
    return ((row <= this.length - 2 && col <= this.length - (row + 2))
            || (row <= this.length - 2 && col >= ((this.length * 2) - 1) + row)
            || (row >= this.getBoardSize() - this.length - 1
            && col <= row - (this.length * 2 - 1))
            || (row >= this.getBoardSize() - this.length - 1
            && col >= this.getBoardSize() - 1 - (row - ((this.length * 2) - 1))));
  }
}
