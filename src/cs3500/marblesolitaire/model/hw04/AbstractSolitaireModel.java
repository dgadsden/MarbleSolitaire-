package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract call for the model of all Marble Solitaire models.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  //row of empty slot
  protected final int sRow;
  //column of empty slot
  protected final int sCol;
  // arm thickness(board size)
  protected final int length;

  protected SlotState[][] board;

  static int SIZE;

  /**
   * Constructor for a Marble Solitaire game that takes in the length of the board and position of
   * the empty slot.
   * @param length the length of the board.
   * @param sRow the row position of the empty slot.
   * @param sCol the col posiition of the empty slot.
   * @throws IllegalArgumentException if lenghth or empty slot is invalid.
   */
  public AbstractSolitaireModel(int length, int sRow, int sCol) throws IllegalArgumentException {
    // if the length is not odd or is off the board
    // (negative) an exception is thrown
    if (length % 2 == 0 || length <= 0) {
      throw new IllegalArgumentException("Invalid arm thickness.");
    }

    this.length = length;

    // if the position of the row or col of the empty slot is not odd or is off the board
    // (negative) an exception is thrown
    if (isOutOfBounds(sRow, sCol) || isInvalid(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }

    SIZE = (length * 3) - 2;

    this.sRow = sRow;
    this.sCol = sCol;
    this.board = new SlotState[SIZE][SIZE];
    this.board = buildBoard();
    this.board[this.sRow][this.sCol] = SlotState.Empty;


  }


  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!(validMove(fromRow, fromCol, toRow, toCol))) {
      throw new IllegalArgumentException("Invalid move.");
    }
    this.board[toRow][toCol] = SlotState.Marble;
    this.board[fromRow][fromCol] = SlotState.Empty;
    this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.getSlotAt(i, j).equals(SlotState.Marble)) {
          if ((i - 2 >= 0 && this.validMove(i, j, i - 2, j))
                  || (i + 2 < this.getBoardSize() && this.validMove(i, j, i + 2, j))
                  || (j - 2 >= 0 && this.validMove(i, j, i, j - 2))
                  || (j + 2 < this.getBoardSize() && this.validMove(i, j, i, j + 2))) {
            return false;
          }
        }
      }
    }
    return true;
  }

  //tested
  @Override
  public int getBoardSize() {
    return (this.length * 3) - 2;
  }

  //tested
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (isOutOfBounds(row, col)) {
      throw new IllegalArgumentException("Invalid position.");
    } else {
      return this.board[row][col];
    }
  }

  @Override
  public int getScore() {
    int counter = 0;
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        switch (getSlotAt(i, j)) {
          case Marble:
            counter += 1;
            break;
          case Empty:
            counter += 0;
            break;
          case Invalid:
            counter += 0;
            break;
          default:
            throw new IllegalArgumentException("invalid");
        }
      }
    }
    return counter;
  }

  private SlotState[][] buildBoard() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (isInvalid(i, j)) {
          this.board[i][j] = SlotState.Invalid;
        } else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
    return board;
  }


  /**
   * Methods that determines if the given slot is invalid according the Marble Solitaire board.
   * @param row position of the given slot.
   * @param col position of the given slot.
   * @return true if the slot is invalid or false if not.
   */
  public abstract boolean isInvalid(int row, int col);

  protected boolean isOutOfBounds(int row, int col) {
    return (row < 0 || row > this.getBoardSize() - 1 || col < 0 || col > this.getBoardSize() - 1);
  }

  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    return ((!(isOutOfBounds(fromRow, fromCol) && isOutOfBounds(toRow, toCol)))
            && !(getSlotAt(fromRow, fromCol).equals(SlotState.Invalid))
            && !(getSlotAt(toRow, toCol).equals(SlotState.Invalid))
            && getSlotAt(fromRow, fromCol).equals(SlotState.Marble)
            && getSlotAt(toRow, toCol).equals(SlotState.Empty)
            && getSlotAt(((fromRow + toRow) / 2), ((fromCol + toCol) / 2)).equals(SlotState.Marble)
            && ((Math.abs(fromCol - toCol) == 2 && (Math.abs(fromRow - toRow) == 0))
            || ((Math.abs(fromCol - toCol) == 0 && (Math.abs(fromRow - toRow) == 2)))));

  }
}
