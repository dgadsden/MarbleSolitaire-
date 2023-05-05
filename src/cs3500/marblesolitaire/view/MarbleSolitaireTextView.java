package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.AbstractTextView;

/**
 * class for the textual representation of a marble solitaire model's board. This class has been
 * refactored to extend the abstract class AbstractTextView in order to get rid of duplicate code.
 *
 * <p>Because European and Triangle have identical implementation of some methods that used to be in
 * English Solitaire model they have been moved to AbstractSolitaireModel: renderBoard(),
 * renderMessage(String).
 */
public class MarbleSolitaireTextView extends AbstractTextView {

  /**
   * Constructor that takes in a MarbleSolitaireModelState so that it can be viewed. Prints in
   * System.out. Has been refactored to call super on AbstractTextView.
   *
   * @param board the board of a Marble Solitaire game.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board) {
    super(board);
  }

  /**
   * Constructor that takes in a MarbleSolitaireModelState and Appendable and adds the results to
   * an appendable. Has been refactored to call super on AbstractTextView.
   *
   * @param board      the board or model of a Marble Solitaire.
   * @param appendable used to set the text view of the board.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board, Appendable appendable) {
    super(board, appendable);
  }

  /**
   * Method that turns a MarbleSolitaireModelState Board into string for viewing purposes.
   * Has been refactored to call super on AbstractTextView. has also been refactored in order to
   * use drawSlotState to reduce duplication.
   *
   * @return the board as a string.
   */
  public String toString() {
    StringBuilder view = new StringBuilder();
    for (int i = 0; i < board.getBoardSize(); i++) {
      for (int j = 0; j < board.getBoardSize(); j++) {
        view.append(drawSlotState(board.getSlotAt(i, j)));
        if ((j == board.getBoardSize() - 1 || board.getSlotAt(i, j + 1)
                == MarbleSolitaireModelState.SlotState.Invalid)
                && board.getSlotAt(i, j) != MarbleSolitaireModelState.SlotState.Invalid) {
          view.append("\n");
          break;
        } else {
          view.append(" ");
        }
      }
    }
    if (view.length() > 0) {
      return view.substring(0, view.length() - 1);
    } else {
      return view.substring(0, view.length());
    }
  }

}
