import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class for the test for the MarbleSolitaireTextView.
 */
public class MarbleSolitaireTextViewTest {
  MarbleSolitaireModel model1;

  MarbleSolitaireModel model2;

  MarbleSolitaireView view1;

  MarbleSolitaireView view2;

  MarbleSolitaireModel euroModel;

  MarbleSolitaireView euroView;

  MarbleSolitaireModel triModel;

  MarbleSolitaireView triView;

  /**
   * Initialized data for the test of the MarbleSolitaireTextView Methods.
   */
  @Before
  public void initData() {
    model1 = new EnglishSolitaireModel();

    model2 = new EnglishSolitaireModel(5, 6, 6);

    view1 = new MarbleSolitaireTextView(model1);

    view2 = new MarbleSolitaireTextView(model2);

    euroModel = new EuropeanSolitaireModel();

    euroView = new MarbleSolitaireTextView(euroModel);

    triModel = new TriangleSolitaireModel();

    triView = new TriangleSolitaireTextView(triModel);
  }


  @Test
  public void toStringWorksArm3() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view1.toString());
  }


  @Test
  public void toStringWorksArm5() {
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", view2.toString());
  }

  @Test
  public void euroToStringTest() {
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", euroView.toString());
  }

  @Test
  public void triangleToStringTest() {
    assertEquals(
            "    _\n"
                    + "   O O\n"
                    + "  O O O\n"
                    + " O O O O\n"
                    + "O O O O O", triView.toString());
  }



  @Test
  public void testFirstConstructor() {
    try {
      MarbleSolitaireModel nullModel = null;
      MarbleSolitaireView illegalView = new MarbleSolitaireTextView(nullModel);
      fail("Given null model or appendable.");
    } catch (IllegalArgumentException e) {
      assertEquals("Given null model.", e.getMessage());
    }
  }

  @Test
  public void testSecondConstructorNullModel() {
    try {
      MarbleSolitaireModel nullModel = null;
      Appendable appendable = new StringBuilder();
      MarbleSolitaireView illegalView = new MarbleSolitaireTextView(nullModel, appendable);
      fail("Given null model or appendable.");
    } catch (IllegalArgumentException e) {
      assertEquals("Given null model or appendable.", e.getMessage());
    }
  }

  @Test
  public void testSecondConstructorNullAppendable() {
    try {
      MarbleSolitaireModel model = new EnglishSolitaireModel();
      Appendable nullAppendable = null;
      MarbleSolitaireView illegalView = new MarbleSolitaireTextView(model, nullAppendable);
      fail("Given null model or appendable.");
    } catch (IllegalArgumentException e) {
      assertEquals("Given null model or appendable.", e.getMessage());
    }
  }

  @Test
  public void testRenderBoard() {
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView appendableView = new MarbleSolitaireTextView(model1, appendable);

    try {
      appendableView.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
    String[] result = appendable.toString().split("\n");
    assertEquals("    O O O", result[0]);
    assertEquals("    O O O", result[1]);
    assertEquals("O O O O O O O", result[2]);
    assertEquals("O O O _ O O O", result[3]);
    assertEquals("O O O O O O O", result[4]);
    assertEquals("    O O O", result[5]);
    assertEquals("    O O O", result[6]);
  }

  @Test
  public void renderBoardWithInput() {
    Reader input = new StringReader("4 6 4 4 2 5 4 5 q");
    Appendable appendable2 = new StringBuilder();
    MarbleSolitaireView appendableView2 = new MarbleSolitaireTextView(model1, appendable2);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model1, appendableView2, input);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "    O O O\n"
            + "    O O _\n"
            + "O O O O _ O O\n"
            + "O O O O O _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 30\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O _\n"
            + "O O O O _ O O\n"
            + "O O O O O _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 30\n", appendable2.toString());
  }

  @Test
  public void renderBoardQuitWorks() {
    Reader input2 = new StringReader("Q");
    Appendable appendable2 = new StringBuilder();
    MarbleSolitaireView appendableView2 = new MarbleSolitaireTextView(model1, appendable2);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model1, appendableView2, input2);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n", appendable2.toString());
  }

  @Test
  public void GameOverWorksWinningGame() {

    Appendable appendable3 = new StringBuilder();
    Reader inputWinningGame = new StringReader("4 6 4 4 6 5 4 5 5 7 5 5 5 4 5 6 5 2 5 4 7 3 5 3 "
            + "4 3 6 3 7 5 7 3 7 3 5 3 3 5 5 5 1 5 3 5 2 3 4 3 4 3 6 3 6 3 6 5 6 5 4 5 4 5 2 5 3 7 "
            + "5 7 5 7 5 5 5 5 5 3 3 1 3 3 3 4 3 2 5 1 3 1 3 1 3 3 1 3 1 5 1 5 3 5 3 6 3 4 3 4 3 2 "
            + "3 2 5 2 5 2 5 4 5 4 3 4 2 4 4 4 q");
    MarbleSolitaireView mockView = new MarbleSolitaireTextView(model1, appendable3);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model1, mockView, inputWinningGame);
    controller.playGame();
    String[] result = appendable3.toString().split("\n");
    assertEquals("Score: 32", result[7]);
    assertEquals("    O O _", result[104]);
    assertEquals("    _ O _", result[105]);
    assertEquals("O O _ O O O O", result[106]);
    assertEquals("O O _ O _ _ O", result[107]);
    assertEquals("O _ _ O O O _", result[108]);
    assertEquals("    O O _", result[109]);
    assertEquals("    _ _ _", result[110]);
    assertEquals("Score: 19", result[111]);
    assertEquals("Game over!", result[248]);
    assertEquals("    _ _ _", result[249]);
    assertEquals("    _ _ _", result[250]);
    assertEquals("_ _ _ _ _ _ _", result[251]);
    assertEquals("_ _ _ O _ _ _", result[252]);
    assertEquals("_ _ _ _ _ _ _", result[253]);
    assertEquals("    _ _ _", result[254]);
    assertEquals("    _ _ _", result[255]);
    assertEquals("Score: 1", result[256]);
  }


  @Test
  public void testRenderMessage() {
    Appendable appendable4 = new StringBuilder();
    MarbleSolitaireView appendableView4 = new MarbleSolitaireTextView(model1, appendable4);
    try {
      appendableView4.renderMessage("Hello my name is Dejah!\n");
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }

    String[] result = appendable4.toString().split("\n");
    assertEquals("Hello my name is Dejah!", result[0]);

    try {
      appendableView4.renderMessage("This is my test.\n");
      appendableView4.renderMessage("The test is rendering a message.\n");
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }

    String[] result2 = appendable4.toString().split("\n");
    assertEquals("Hello my name is Dejah!", result2[0]);
    assertEquals("This is my test.", result2[1]);
    assertEquals("The test is rendering a message.", result2[2]);
  }

//  @Test
//  public void renderTryAgainMessage() {
//    Reader input = new StringReader("-4 2 4 4 q");
//    Appendable appendable5 = new StringBuilder();
//    MarbleSolitaireView appendableView5 = new MarbleSolitaireTextView(model1, appendable5);
//    MarbleSolitaireController controller =
//            new MarbleSolitaireControllerImpl(model1, appendableView5, input);
//    controller.playGame();
//    assertTrue(appendable5.toString().contains("Invalid move. Play again. Must be a valid move or " +
//            "'q' " +
//            "for quit.\n"));
//  }

}