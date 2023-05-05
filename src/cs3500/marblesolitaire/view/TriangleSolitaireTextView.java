package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.AbstractTextView;

/**
 * Class for the textual view of Triangle Solitaire board.
 */
public class TriangleSolitaireTextView extends AbstractTextView {

  /**
   * Constructor for TriangleSolitaireTextView that takes in a MarbleSolitaireModelState calls
   * super AbstractTextView.
   *
   * @param game the MarbleSolitaireModelState that the game takes in.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game) {
    super(game);
  }

  /**
   * Constructor for TriangleSolitaireTextView that takes in a MarbleSolitaireModelState, and an
   * appendable. calls super AbstractTextView.
   *
   * @param game       the MarbleSolitaireModelState that the game takes in.
   * @param appendable an Appendable that transmits the outputs of the text view.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game, Appendable appendable) {
    super(game, appendable);
  }

  /**
   * Method that turns a MarbleSolitaireModelState Board into string for viewing purposes.
   * use drawSlotState to reduce duplication.
   *
   * @return the MarbleSolitaireModelState Board as a string.
   */
  @Override
  public String toString() {
    StringBuilder view = new StringBuilder();
    for (int i = 0; i < board.getBoardSize(); i++) {
      int spaces = i;
      while (spaces < this.board.getBoardSize() - 1) {
        view.append(" ");
        spaces++;
      }
      for (int j = 0; j <= i; j++) {
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
