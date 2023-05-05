import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.AbstractTextView;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Class for test of the euro and triangle model.
 */
public class EuroAndTriModelTest {

  MarbleSolitaireModel euroModelDefault;

  MarbleSolitaireModel euroModelSideLength5;

  MarbleSolitaireModel euroModelCustomEmptySlot;

  MarbleSolitaireModel triangleModelDefault;

  MarbleSolitaireModel triangleModelSideLength5;

  MarbleSolitaireModel triangleModelCustomEmptySlot;

  @Before
  public void initData() {
    euroModelDefault = new EuropeanSolitaireModel();

    euroModelSideLength5 = new EuropeanSolitaireModel(5);

    euroModelCustomEmptySlot = new EuropeanSolitaireModel(4, 4);


    triangleModelDefault = new EuropeanSolitaireModel();

    triangleModelSideLength5 = new EuropeanSolitaireModel(5);

    triangleModelCustomEmptySlot = new EuropeanSolitaireModel(4, 4);

  }

  // Euro Model Test:
  // test for the constructors
  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegativeEmptySlotRows() {
    new EuropeanSolitaireModel(-3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegativeEmptySlotCols() {
    new EuropeanSolitaireModel(3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegativeEmptySlot() {
    new EuropeanSolitaireModel(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot1() {
    new EuropeanSolitaireModel(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot2() {
    new EuropeanSolitaireModel(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot3() {
    new EuropeanSolitaireModel(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot4() {
    new EuropeanSolitaireModel(6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot5() {
    new EuropeanSolitaireModel(0, 1);
  }


  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot8() {
    new EuropeanSolitaireModel(6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot9() {
    new EuropeanSolitaireModel(0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot12() {
    new EuropeanSolitaireModel(6, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot13() {
    new EuropeanSolitaireModel(0, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot14() {
    new EuropeanSolitaireModel(1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot15() {
    new EuropeanSolitaireModel(5, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot16() {
    new EuropeanSolitaireModel(6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsEvenArmThickness() {
    new EuropeanSolitaireModel(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegativeArmThickness() {
    new EuropeanSolitaireModel(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegative1() {
    new EuropeanSolitaireModel(-3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegative2() {
    new EuropeanSolitaireModel(3, -3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegative3() {
    new EuropeanSolitaireModel(3, 3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsEven1() {
    new EuropeanSolitaireModel(4, 3, 3);
  }

  // test for get board size
  @Test
  public void getBoardSizeWorks() {
    assertEquals(euroModelDefault.getBoardSize(), 7);
  }

  @Test
  public void getBoardSizeWorksWithCustomBoard() {
    assertEquals(euroModelCustomEmptySlot.getBoardSize(), 7);
  }

  @Test
  public void getBoardSizeWorksWithSizeOtherThan3() {
    assertEquals(euroModelSideLength5.getBoardSize(), 13);
  }

  // test for getSlotAt
  @Test
  public void getSlotAtworksFindEmpty() {
    assertEquals(euroModelDefault.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
  }

  @Test
  public void getSlotAtworksFindMarble() {
    assertEquals(euroModelDefault.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void getSlotAtworksFindInvalid() {
    assertEquals(euroModelDefault.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Test
  public void getSlotAtworksWithCustomFindEmpty() {
    assertEquals(euroModelCustomEmptySlot.getSlotAt(4, 4),
            MarbleSolitaireModelState.SlotState.Empty);
  }

  @Test
  public void getSlotAtworksWithCustomFindMarble() {
    assertEquals(euroModelCustomEmptySlot.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void getSlotAtworksWithCustomFindInvalid() {
    assertEquals(euroModelCustomEmptySlot.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Test
  public void getSlotAtworksWithCustom2FindEmpty() {
    assertEquals(euroModelSideLength5.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Empty);
  }

  @Test
  public void getSlotAtworksWithCustom2FindMarble() {
    assertEquals(euroModelSideLength5.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void getSlotAtworksWithCustom2FindInvalid() {
    assertEquals(euroModelSideLength5.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
  }

  //invalid getSlots
  @Test(expected = IllegalArgumentException.class)
  public void getSlotThrowWhenOutofBounds() {
    euroModelSideLength5.getSlotAt(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getSlotThrowWhenOutofBounds2() {
    euroModelDefault.getSlotAt(0, 100);
  }

  //test for getScore no move
  @Test
  public void getScoreWorksNoMoves() {
    assertEquals(euroModelDefault.getScore(), 36);
  }

  @Test
  public void getScoreWorksNoMoves2() {
    assertEquals(euroModelCustomEmptySlot.getScore(), 36);
  }

  @Test
  public void getScoreWorksNoMoves3() {
    assertEquals(euroModelSideLength5.getScore(), 128);
  }

  //test getScore after moves;
  @Test
  public void getScoreWorksWithMoves() {

    euroModelDefault.move(3, 5, 3, 3);
    assertEquals(euroModelDefault.getScore(), 35);

  }

  @Test
  public void getScoreWorksWithMoves2() {

    euroModelDefault.move(3, 5, 3, 3);
    euroModelDefault.move(3, 2, 3, 4);

    assertEquals(euroModelDefault.getScore(), 34);

  }

  //test for move
  @Test
  public void moveWorkAndGetScore() {
    assertEquals(euroModelDefault.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(euroModelDefault.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(euroModelDefault.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    // move marble to empty middle slot
    euroModelDefault.move(3, 5, 3, 3);
    assertEquals(euroModelDefault.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(euroModelDefault.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(euroModelDefault.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Empty);

  }

  @Test
  public void moveWorkWithCustom() {
    assertEquals(euroModelSideLength5.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(euroModelSideLength5.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(euroModelSideLength5.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Empty);
    // move marble to empty middle slot
    euroModelSideLength5.move(4, 6, 6, 6);
    assertEquals(euroModelSideLength5.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(euroModelSideLength5.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(euroModelSideLength5.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Marble);

  }

  //invalid moves
  @Test(expected = IllegalArgumentException.class)
  public void moveThrowsMoveEmpty() {
    euroModelDefault.move(3, 3, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveThrowsMoveInvalid() {
    euroModelDefault.move(0, 0, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveThrowsMoveMarbletoMarble() {
    euroModelDefault.move(1, 2, 3, 2);
  }


  @Test(expected = IllegalArgumentException.class)
  public void moveThrowsMoveMarbletoFar() {
    euroModelDefault.move(0, 3, 3, 3);
  }


  //test for isGameOver
  @Test
  public void gameIsNotOver() {
    assertEquals(euroModelDefault.isGameOver(), false);
  }

  @Test
  public void gameIsNotOver2() {
    euroModelDefault.move(1, 3, 3, 3);
    assertEquals(euroModelDefault.isGameOver(), false);
  }

  //test for Triangle
  // test for constructors

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTriangleDisallowsNeg() {
    MarbleSolitaireModel badtTriGame = new TriangleSolitaireModel(-9);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTriangleDisallows0() {
    MarbleSolitaireModel badtTriGame = new TriangleSolitaireModel(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTriangleDisallowsNeg2() {
    MarbleSolitaireModel badtTriGame = new TriangleSolitaireModel(-3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTriangleDisallows02() {
    MarbleSolitaireModel badtTriGame = new TriangleSolitaireModel(0, 7);
  }


  @Test
  public void testGetScoreTriDefault1() {
    assertEquals(14, triangleModelDefault.getScore());
    triangleModelDefault.move(2, 0, 0, 0);
    assertEquals(13, triangleModelDefault.getScore());
    triangleModelDefault.move(2, 2, 2, 0);
    assertEquals(12, triangleModelDefault.getScore());
  }

  @Test
  public void testGetSlotTriDefault1() {
    assertEquals(triangleModelDefault.getSlotAt(0,
            0), MarbleSolitaireModelState.SlotState.Empty);
  }

  @Test
  public void testGetSlotTriDefault2() {
    assertEquals(triangleModelDefault.getSlotAt(0,
            1), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Test
  public void testGetSlotTriDefault3() {
    assertEquals(triangleModelDefault.getSlotAt(0,
            2), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Test
  public void testGetSlotTriDefault4() {
    assertEquals(triangleModelDefault.getSlotAt(1,
            0), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void testGetSlotTriDefault5() {
    assertEquals(triangleModelDefault.getSlotAt(1,
            1), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void testGameOver() {
    MarbleSolitaireModel winningTriGame = new TriangleSolitaireModel(4, 1, 0);
    assertEquals(false, winningTriGame.isGameOver());
    winningTriGame.move(3, 0, 1, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, winningTriGame.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, winningTriGame.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, winningTriGame.getSlotAt(2, 0));
    winningTriGame.move(0, 0, 2, 0);
    winningTriGame.move(2, 2, 0, 0);
    winningTriGame.move(3, 2, 3, 0);
    winningTriGame.move(3, 0, 1, 0);
    winningTriGame.move(0, 0, 2, 0);
    winningTriGame.move(2, 0, 2, 2);
    winningTriGame.move(3, 3, 1, 1);
    assertEquals(true, winningTriGame.isGameOver());
  }

  @Test
  public void testGetScoreTri() {
    assertEquals(14, triangleModelDefault.getScore());
    triangleModelDefault.move(2, 0, 0, 0);
    assertEquals(13, triangleModelDefault.getScore());
    triangleModelDefault.move(2, 2, 2, 0);
    assertEquals(12, triangleModelDefault.getScore());
  }

  @Test
  public void testRenderBoard() {
    Appendable appendable = new StringBuilder();
    AbstractTextView aView1 = new MarbleSolitaireTextView(euroModelDefault, appendable);
    try {
      aView1.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
    String[] result = appendable.toString().split("\n");
    assertEquals("    O O O", result[0]);
    assertEquals("  O O O O O", result[1]);
    assertEquals("O O O O O O O", result[2]);
    assertEquals("O _ O O O O O", result[3]);
    assertEquals("O O O O O O O", result[4]);
    assertEquals("  O O O O O", result[5]);
    assertEquals("    O O O", result[6]);


    Reader input = new StringReader("4 2 4 4 6 3 4 3 q");
    Appendable appendable1 = new StringBuilder();
    AbstractTextView aView2 = new MarbleSolitaireTextView(euroModelDefault, appendable1);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(euroModelDefault, aView2, input);
    controller.playGame();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 35\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ O O O O O\n"
            + "O O _ O O O O\n"
            + "  O _ O O O\n"
            + "    O O O\n"
            + "Score: 34\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ O O O O O\n"
            + "O O _ O O O O\n"
            + "  O _ O O O\n"
            + "    O O O\n"
            + "Score: 34\n", appendable1.toString());

    Reader input1 = new StringReader("q");
    Appendable appendable2 = new StringBuilder();
    AbstractTextView aView3 = new MarbleSolitaireTextView(euroModelDefault, appendable2);
    MarbleSolitaireController controller1 =
            new MarbleSolitaireControllerImpl(euroModelDefault, aView3, input1);
    controller1.playGame();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n", appendable2.toString());

    Reader input2 = new StringReader("4 q");
    Appendable appendable3 = new StringBuilder();
    AbstractTextView aView4 = new MarbleSolitaireTextView(euroModelDefault, appendable3);
    MarbleSolitaireController controller2 =
            new MarbleSolitaireControllerImpl(euroModelDefault, aView4, input2);
    controller2.playGame();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n", appendable3.toString());

    Reader input3 = new StringReader("4 2 q 4");
    Appendable appendable4 = new StringBuilder();
    AbstractTextView aView5 = new MarbleSolitaireTextView(euroModelDefault, appendable4);
    MarbleSolitaireController controller3 =
            new MarbleSolitaireControllerImpl(euroModelDefault, aView5, input3);
    controller3.playGame();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n", appendable4.toString());

    Reader input4 = new StringReader("4 2 q 4");
    Appendable appendable5 = new StringBuilder();
    AbstractTextView aView6 = new MarbleSolitaireTextView(euroModelDefault, appendable5);
    MarbleSolitaireController controller4 =
            new MarbleSolitaireControllerImpl(euroModelDefault, aView6, input4);
    controller4.playGame();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n", appendable5.toString());

    Reader input4a = new StringReader("4 2 4 q");
    Appendable appendable50 = new StringBuilder();
    AbstractTextView aView6a = new MarbleSolitaireTextView(euroModelDefault, appendable50);
    MarbleSolitaireController controller4a =
            new MarbleSolitaireControllerImpl(euroModelDefault, aView6a, input4a);
    controller4a.playGame();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n", appendable50.toString());
    Appendable appendable6 = new StringBuilder();
    AbstractTextView aViewT1 = new TriangleSolitaireTextView(triangleModelDefault, appendable6);
    try {
      aViewT1.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
    String[] resultT1 = appendable6.toString().split("\n");
    assertEquals("   O", resultT1[0]);
    assertEquals("  _ O", resultT1[1]);
    assertEquals(" O O O", resultT1[2]);
    assertEquals("O O O O", resultT1[3]);

    Reader input1T = new StringReader("3 1 1 1 4 3 2 1 q");
    Appendable appendable1T = new StringBuilder();
    AbstractTextView aView2T = new TriangleSolitaireTextView(triangleModelDefault, appendable1T);
    MarbleSolitaireController controller1T =
            new MarbleSolitaireControllerImpl(triangleModelDefault, aView2T, input1T);
    controller1T.playGame();
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O\n"
            + "Score: 14\n"
            + "    O\n"
            + "   _ O\n"
            + "  _ O O\n"
            + " O O O O\n"
            + "O O O O O\n"
            + "Score: 13\n"
            + "    O\n"
            + "   O O\n"
            + "  _ _ O\n"
            + " O O _ O\n"
            + "O O O O O\n"
            + "Score: 12\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O\n"
            + "   O O\n"
            + "  _ _ O\n"
            + " O O _ O\n"
            + "O O O O O\n"
            + "Score: 12\n", appendable1T.toString());

    Reader input10T = new StringReader("q");
    Appendable appendable2T = new StringBuilder();
    AbstractTextView aView3T = new TriangleSolitaireTextView(triangleModelDefault, appendable2T);
    MarbleSolitaireController controller10T =
            new MarbleSolitaireControllerImpl(triangleModelDefault, aView3T, input10T);
    controller10T.playGame();
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O _ O O\n"
            + "O O O O O\n"
            + "Score: 14\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O _ O O\n"
            + "O O O O O\n"
            + "Score: 14\n", appendable2T.toString());


    Reader input2T = new StringReader("4 q");
    Appendable appendable3T = new StringBuilder();
    AbstractTextView aView4T = new TriangleSolitaireTextView(triangleModelDefault, appendable3T);
    MarbleSolitaireController controller2T =
            new MarbleSolitaireControllerImpl(triangleModelDefault, aView4T, input2T);
    controller2T.playGame();
    assertEquals("      _\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O\n"
            + "Score: 27\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "      _\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O\n"
            + "Score: 27\n", appendable3T.toString());


    Reader input3T = new StringReader("4 2 q 4");
    Appendable appendable4T = new StringBuilder();
    AbstractTextView aView5T = new TriangleSolitaireTextView(triangleModelDefault, appendable4T);
    MarbleSolitaireController controller3T =
            new MarbleSolitaireControllerImpl(triangleModelDefault, aView5T, input3T);
    controller3T.playGame();
    assertEquals("   O\n"
            + "  _ O\n"
            + " O O O\n"
            + "O O O O\n"
            + "Score: 9\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "   O\n"
            + "  _ O\n"
            + " O O O\n"
            + "O O O O\n"
            + "Score: 9\n", appendable4T.toString());

    Reader input4T = new StringReader("4 2 q 4");
    Appendable appendable5T = new StringBuilder();
    AbstractTextView aView6T = new TriangleSolitaireTextView(triangleModelDefault, appendable5T);
    MarbleSolitaireController controller4T =
            new MarbleSolitaireControllerImpl(triangleModelDefault, aView6T, input4T);
    controller4T.playGame();
    assertEquals("   O\n"
            + "  _ O\n"
            + " O O O\n"
            + "O O O O\n"
            + "Score: 9\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "   O\n"
            + "  _ O\n"
            + " O O O\n"
            + "O O O O\n"
            + "Score: 9\n", appendable5T.toString());

    Reader input4aT = new StringReader("4 2 4 q");
    Appendable appendable50T = new StringBuilder();
    AbstractTextView view = new TriangleSolitaireTextView(triangleModelDefault, appendable50T);
    MarbleSolitaireController controller4aT =
            new MarbleSolitaireControllerImpl(triangleModelDefault, view, input4aT);
    controller4aT.playGame();
    assertEquals("   O\n"
            + "  _ O\n"
            + " O O O\n"
            + "O O O O\n"
            + "Score: 9\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "   O\n"
            + "  _ O\n"
            + " O O O\n"
            + "O O O O\n"
            + "Score: 9\n", appendable50T.toString());
  }

}
