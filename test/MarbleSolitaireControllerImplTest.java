import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Class of test for the Controllers of the game.
 */
public class MarbleSolitaireControllerImplTest {
  @Test
  public void testConstructor() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Readable input = new StringReader("4 2 4 4 q");
    Readable nullInput = null;
    MarbleSolitaireModel nullModel = null;
    MarbleSolitaireView nullView = null;

    try {
      MarbleSolitaireController illegalController1 =
              new MarbleSolitaireControllerImpl(nullModel, view, input);
      fail("Given null model, view or input.");
    } catch (IllegalArgumentException e) {
      assertEquals("Given null model, view or input.", e.getMessage());
    }

    try {
      MarbleSolitaireController illegalController2 =
              new MarbleSolitaireControllerImpl(model, nullView, input);
      fail("Given null model, view or input.");
    } catch (IllegalArgumentException e) {
      assertEquals("Given null model, view or input.", e.getMessage());
    }


    try {
      MarbleSolitaireController illegalController3 =
              new MarbleSolitaireControllerImpl(model, view, nullInput);
      fail("Given null model, view or input.");
    } catch (IllegalArgumentException e) {
      assertEquals("Given null model, view or input.", e.getMessage());
    }

  }

  @Test(expected = IllegalStateException.class)
  public void testInputExceptionsZeroGiven() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView mockView1 = new MarbleSolitaireTextView(model, appendable);
    Reader zeroInput = new StringReader("");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, mockView1, zeroInput);
    controller.playGame();
    assertEquals("Four or more moves needed.", appendable.toString());
  }


  @Test(expected = IllegalStateException.class)
  public void testInputExceptionsOneGiven() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView mockView1 = new MarbleSolitaireTextView(model, appendable);
    Reader oneInput = new StringReader("4");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, mockView1, oneInput);
    controller.playGame();
    assertEquals("Four or more moves needed.", appendable.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testInputExceptionsTwoGiven() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView mockView1 = new MarbleSolitaireTextView(model, appendable);
    Reader twoInput = new StringReader("4 2");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, mockView1, twoInput);
    controller.playGame();
    assertEquals("Four or more moves needed.", appendable.toString());
  }


  @Test(expected = IllegalStateException.class)
  public void testInputExceptionsThreeGiven() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView mockView1 = new MarbleSolitaireTextView(model, appendable);
    Reader twoInput = new StringReader("4 2 6");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, mockView1, twoInput);
    controller.playGame();
    assertEquals("Four or more moves needed.", appendable.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testInputExceptionsInputNotInRulesOtherThanQ() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView mockView1 = new MarbleSolitaireTextView(model, appendable);
    Reader twoInput = new StringReader("m");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, mockView1, twoInput);
    controller.playGame();
    assertEquals("Invalid move. Play again. Must be a valid move or 'q' for quit.\n",
            appendable.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testInputExceptionsInputNotInRulesBadInputs() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView mockView1 = new MarbleSolitaireTextView(model, appendable);
    Reader twoInput = new StringReader("-3 m");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, mockView1, twoInput);
    controller.playGame();
    assertEquals("Invalid move. Play again. Must be a valid move or 'q' for quit.\n",
            appendable.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testInputExceptionsInputNotInRulesNegativeMoves() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView mockView1 = new MarbleSolitaireTextView(model, appendable);
    Reader twoInput = new StringReader("-3 -2 -5 -6");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, mockView1, twoInput);
    controller.playGame();
    assertEquals("Invalid move. Play again. Must be a valid move or 'q' for quit.\n",
            appendable.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testInputExceptionsInputNotInRulesSandwich() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView mockView1 = new MarbleSolitaireTextView(model, appendable);
    Reader twoInput = new StringReader("4 2 o 4 4");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, mockView1, twoInput);
    controller.playGame();
    assertEquals("Invalid move. Play again. Must be a valid move or 'q' for quit.\n",
            appendable.toString());
  }

}