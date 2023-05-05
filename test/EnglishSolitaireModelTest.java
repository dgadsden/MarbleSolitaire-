import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;

/**
 * Testing class for the EnglishSolitaireModel class. this class tests all the methods written for
 * this class.
 */
public class EnglishSolitaireModelTest {

  MarbleSolitaireModel model1;

  MarbleSolitaireModel model2;

  MarbleSolitaireModel model3;

  @Before
  public void initData() {
    model1 = new EnglishSolitaireModel();

    model2 = new EnglishSolitaireModel(3, 3, 3);

    model3 = new EnglishSolitaireModel(5, 6, 6);
  }

  // test for the constructors
  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegativeEmptySlotRows() {
    new EnglishSolitaireModel(-3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegativeEmptySlotCols() {
    new EnglishSolitaireModel(3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegativeEmptySlot() {
    new EnglishSolitaireModel(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot1() {
    new EnglishSolitaireModel(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot2() {
    new EnglishSolitaireModel(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot3() {
    new EnglishSolitaireModel(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot4() {
    new EnglishSolitaireModel(6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot5() {
    new EnglishSolitaireModel(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot6() {
    new EnglishSolitaireModel(1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot7() {
    new EnglishSolitaireModel(5, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot8() {
    new EnglishSolitaireModel(6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot9() {
    new EnglishSolitaireModel(0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot10() {
    new EnglishSolitaireModel(1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot11() {
    new EnglishSolitaireModel(5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot12() {
    new EnglishSolitaireModel(6, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot13() {
    new EnglishSolitaireModel(0, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot14() {
    new EnglishSolitaireModel(1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot15() {
    new EnglishSolitaireModel(5, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsInvalidEmptySlot16() {
    new EnglishSolitaireModel(6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsEvenArmThickness() {
    new EnglishSolitaireModel(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegativeArmThickness() {
    new EnglishSolitaireModel(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegative1() {
    new EnglishSolitaireModel(-3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegative2() {
    new EnglishSolitaireModel(3, -3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsNegative3() {
    new EnglishSolitaireModel(3, 3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void esmlConstructorDisallowsEven1() {
    new EnglishSolitaireModel(4, 3, 3);
  }

  // test for get board size
  @Test
  public void getBoardSizeWorks() {
    assertEquals(model1.getBoardSize(), 7);
  }

  @Test
  public void getBoardSizeWorksWithCustomBoard() {
    assertEquals(model2.getBoardSize(), 7);
  }

  @Test
  public void getBoardSizeWorksWithSizeOtherThan3() {
    assertEquals(model3.getBoardSize(), 13);
  }

  // test for getSlotAt
  @Test
  public void getSlotAtworksFindEmpty() {
    assertEquals(model1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
  }

  @Test
  public void getSlotAtworksFindMarble() {
    assertEquals(model1.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void getSlotAtworksFindInvalid() {
    assertEquals(model1.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Test
  public void getSlotAtworksWithCustomFindEmpty() {
    assertEquals(model2.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
  }

  @Test
  public void getSlotAtworksWithCustomFindMarble() {
    assertEquals(model2.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void getSlotAtworksWithCustomFindInvalid() {
    assertEquals(model2.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Test
  public void getSlotAtworksWithCustom2FindEmpty() {
    assertEquals(model3.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Empty);
  }

  @Test
  public void getSlotAtworksWithCustom2FindMarble() {
    assertEquals(model3.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void getSlotAtworksWithCustom2FindInvalid() {
    assertEquals(model3.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
  }

  //invalid getSlots
  @Test(expected = IllegalArgumentException.class)
  public void getSlotThrowWhenOutofBounds() {
    model3.getSlotAt(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getSlotThrowWhenOutofBounds2() {
    model1.getSlotAt(0, 100);
  }

  //test for getScore no move
  @Test
  public void getScoreWorksNoMoves() {
    assertEquals(model1.getScore(), 32);
  }

  @Test
  public void getScoreWorksNoMoves2() {
    assertEquals(model2.getScore(), 32);
  }

  @Test
  public void getScoreWorksNoMoves3() {
    assertEquals(model3.getScore(), 104);
  }

  //test getScore after moves;
  @Test
  public void getScoreWorksWithMoves() {

    model1.move(3, 5, 3, 3);
    assertEquals(model1.getScore(), 31);

  }

  @Test
  public void getScoreWorksWithMoves2() {

    model1.move(3, 5, 3, 3);
    model1.move(3, 2, 3, 4);

    assertEquals(model1.getScore(), 30);

  }

  //test for move
  @Test
  public void moveWorkAndGetScore() {
    assertEquals(model1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(model1.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(model1.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    // move marble to empty middle slot
    model1.move(3, 5, 3, 3);
    assertEquals(model1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(model1.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(model1.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Empty);

  }

  @Test
  public void moveWorkWithCustom() {
    assertEquals(model3.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(model3.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(model3.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Empty);
    // move marble to empty middle slot
    model3.move(4, 6, 6, 6);
    assertEquals(model3.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(model3.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(model3.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Marble);

  }

  //invalid moves
  @Test(expected = IllegalArgumentException.class)
  public void moveThrowsMoveEmpty() {
    model1.move(3, 3, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveThrowsMoveInvalid() {
    model1.move(0, 0, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveThrowsMoveMarbletoMarble() {
    model1.move(1, 2, 3, 2);
  }


  @Test(expected = IllegalArgumentException.class)
  public void moveThrowsMoveMarbletoFar() {
    model1.move(0, 3, 3, 3);
  }


  //test for isGameOver
  @Test
  public void gameIsNotOver() {
    assertEquals(model1.isGameOver(), false);
  }

  @Test
  public void gameIsNotOver2() {
    model1.move(1, 3, 3, 3);
    assertEquals(model1.isGameOver(), false);
  }

  @Test
  public void gameIsOver() {
    model1.move(1, 3, 3, 3);
    model1.move(2, 1, 2, 3);
    model1.move(0, 2, 2, 2);
    model1.move(0, 4, 0, 2);
    model1.move(3, 2, 1, 2);
    model1.move(0, 2, 2, 2);
    model1.move(2, 3, 2, 1);
    model1.move(5, 2, 3, 2);
    model1.move(4, 0, 4, 2);
    model1.move(2, 0, 4, 0);
    model1.move(2, 1, 4, 1);
    model1.move(3, 2, 5, 2);
    model1.move(4, 0, 4, 2);
    model1.move(4, 3, 4, 1);
    model1.move(4, 5, 4, 3);
    model1.move(6, 4, 4, 4);
    model1.move(5, 2, 5, 4);
    model1.move(6, 2, 6, 4);
    model1.move(4, 4, 4, 2);
    model1.move(6, 4, 4, 4);
    model1.move(4, 1, 4, 3);
    model1.move(4, 3, 4, 5);
    model1.move(2, 4, 4, 4);
    model1.move(2, 6, 2, 4);
    model1.move(3, 6, 3, 4);
    model1.move(3, 4, 5, 4);
    model1.move(4, 6, 4, 4);
    model1.move(5, 4, 3, 4);
    model1.move(3, 3, 3, 5);
    model1.move(1, 4, 3, 4);
    model1.move(3, 5, 3, 3);

    assertEquals(model1.isGameOver(), true);
  }

}