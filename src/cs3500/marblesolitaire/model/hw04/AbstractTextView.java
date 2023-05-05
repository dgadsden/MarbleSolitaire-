package cs3500.marblesolitaire.model.hw04;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Abstract class for the textual view of all Marble Solitaire Models.
 */
public abstract class AbstractTextView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState board;
  protected Appendable appendable;

  /**
   * Constructor that takes in a MarbleSolitaireModelState so that it can be viewed. Prints in
   * System.out.
   *
   * @param board the board of a Marble Solitaire game.
   */
  public AbstractTextView(MarbleSolitaireModelState board) {
    if (board == null) {
      throw new IllegalArgumentException("Given null model.");
    }
    this.board = board;
    this.appendable = System.out;
  }

  /**
   * Constructor that takes in a MarbleSolitaireModelState and Appendable and adds the results to
   * an appendable.
   *
   * @param board      the board or model of a Marble Solitaire.
   * @param appendable used to set the text view of the board.
   */
  public AbstractTextView(MarbleSolitaireModelState board, Appendable appendable) {

    if (board == null || appendable == null) {
      throw new IllegalArgumentException("Given null model or appendable.");
    }

    this.board = board;
    this.appendable = appendable;

  }

  /**
   * Function that turns a MarbleSolitaireModelState Board into string for viewing purposes.
   *
   * @return the board as a string.
   */
  public abstract String toString();

  @Override
  public void renderBoard() throws IOException {
    try {
      this.appendable.append(this.toString());
    } catch (IOException e) {
      throw new IllegalStateException("Something went wrong while writing to the appendable.");
    }
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.appendable.append(message);
    } catch (IOException e) {
      throw new IllegalStateException("Something went wrong while writing to the appendable.");
    }
  }

  /**
   * Method that translates the slot state of a Marble Solitaire Slot into a string. Refactored
   * (added) in order to get rid of some duplicate code in the toString methods.
   *
   * @param slotState either empty, invalid, or a marble.
   * @return the slot state of the given slot as a string.
   */
  protected String drawSlotState(MarbleSolitaireModelState.SlotState slotState) {
    switch (slotState) {
      case Invalid:
        return " ";
      case Empty:
        return "_";
      case Marble:
        return "O";
      default:
        throw new RuntimeException("Error writing the Slot State");
    }
  }

}
