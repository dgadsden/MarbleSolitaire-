package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Class that represents the model of a marble solitaire game. An English marble solitaire game
 * has arm thickness as well as an empty slot position. It has been refactored to extend the
 * abstract class AbstractSolitaireModel to reduce duplicate code.
 *
 * <p>Because European has identical implementation of some methods that used to be in English
 * Solitaire model they have been moved to AbstractSolitaireModel: move(int, int, int,
 * * int), isGameOver(), getBoardSize(), getSlotAt(int, int),
 * * getScore()), initializeBoard(), and validMove(int, int, int, int).
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {


  /**
   * Default constructor that set arm thickness at 3 and the empty slot in the middle(3,3). Has
   * been refactored to call super on AbstractSolitaireModel.
   */
  public EnglishSolitaireModel() {
    super(3, 3, 3);
  }


  /**
   * Constructor has a set arm thickness that takes in position of empty slot.
   * Has been refactored to call super on AbstractSolitaireModel.
   *
   * @param sRow the row position on the Marble Solitaire board.
   * @param sCol the column position on the Marble Solitaire board.
   */
  public EnglishSolitaireModel(int sRow, int sCol) {

    super(3, sRow, sCol);
  }


  /**
   * Constructor that takes a given arm thickness and has a set empty slot position at the middle of
   * the board. Has been refactored to call super on AbstractSolitaireModel.
   *
   * @param armThickness the arm thickness of the English Marble Solitaire board.
   */
  public EnglishSolitaireModel(int armThickness) {

    super(armThickness, ((3 * armThickness) - 2) / 2, ((3 * armThickness) - 2) / 2);
  }


  /**
   * Constructor that takes a given arm thickness and has a set empty slot position at the middle of
   * the board. Has been refactored to call super on AbstractSolitaireModel.
   *
   * @param armThickness the arm thickness of the English Marble Solitaire board.
   * @param sRow         the row position on the English Marble Solitaire board.
   * @param sCol         the column  position on the English Marble Solitaire board.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {

    super(armThickness, sRow, sCol);
  }


  /**
   * Methods that determines if the given slot is invalid in terms of English Solitaire standards.
   *
   * @param row the row position of the given slot.
   * @param col the col position of the given slot.
   * @return true if the slot is invalid or false if it is not.
   */
  @Override
  public boolean isInvalid(int row, int col) {
    return ((row < this.length - 1 && col < this.length - 1)
            || (row < this.length - 1 && col > this.getBoardSize() - this.length)
            || (row > this.getBoardSize() - this.length && col < this.length - 1)
            || (row > this.getBoardSize() - this.length && col >
            this.getBoardSize() - this.length));
  }
}
