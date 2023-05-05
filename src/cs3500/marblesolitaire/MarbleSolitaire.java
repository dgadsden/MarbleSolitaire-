package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Class for the main function of the MarbleSolitaire program.
 */
public final class MarbleSolitaire {

  /**
   * main method that runs the code. takes in arguements.
   * @param args inputs to the function that control the gameplay.
   */
  public static void main(String[] args) {
    Appendable ap = System.out;
    Readable rd = new InputStreamReader(System.in);
    int size = 0;
    int row = 0;
    int col = 0;
    boolean givenSize = false;
    boolean givenHole = false;

    int i = 1;
    while (i < args.length) {
      if (args[i].equalsIgnoreCase("-size")) {
        size = Integer.parseInt(args[i + 1]);
        i += 2;
        givenSize = true;
      } else if (args[i].equalsIgnoreCase("-hole")) {
        row = Integer.parseInt(args[i + 1]);
        col = Integer.parseInt(args[i + 2]);
        i += 3;
        givenHole = true;
      } else {
        i++;
      }
    }

    switch (args[0]) {
      case "english":
        MarbleSolitaireModel englishModel = null;
        if (!givenSize && !givenHole) {
          englishModel = new EnglishSolitaireModel();
        } else if (givenSize && !givenHole) {
          englishModel = new EnglishSolitaireModel(size);
        } else if (!givenSize && givenHole) {
          englishModel = new EnglishSolitaireModel(row, col);
        } else if (givenSize && givenHole) {
          englishModel = new EnglishSolitaireModel(size, row, col);
        }
        MarbleSolitaireTextView viewEN = new MarbleSolitaireTextView(englishModel);
        MarbleSolitaireControllerImpl controllerEN =
                new MarbleSolitaireControllerImpl(englishModel, viewEN, rd);
        controllerEN.playGame();
        break;
      case "european":
        MarbleSolitaireModel euroModel = null;
        if (!givenSize && !givenHole) {
          euroModel = new EuropeanSolitaireModel();
        } else if (givenSize && !givenHole) {
          euroModel = new EuropeanSolitaireModel(size);
        } else if (!givenSize && givenHole) {
          euroModel = new EuropeanSolitaireModel(row, col);
        } else if (givenSize && givenHole) {
          euroModel = new EuropeanSolitaireModel(size, row, col);
        }
        MarbleSolitaireTextView viewEU = new MarbleSolitaireTextView(euroModel);
        MarbleSolitaireControllerImpl controllerEU =
                new MarbleSolitaireControllerImpl(euroModel, viewEU, rd);
        controllerEU.playGame();
        break;
      case "triangle":
        MarbleSolitaireModel triModel = null;
        if (!givenSize && !givenHole) {
          triModel = new TriangleSolitaireModel();
        } else if (givenSize && !givenHole) {
          triModel = new TriangleSolitaireModel(size);
        } else if (!givenSize && givenHole) {
          triModel = new TriangleSolitaireModel(row, col);
        } else if (givenSize && givenHole) {
          triModel = new TriangleSolitaireModel(size, row, col);
        }
        MarbleSolitaireView viewTri = new TriangleSolitaireTextView(triModel, ap);
        MarbleSolitaireControllerImpl controllerTri =
                new MarbleSolitaireControllerImpl(triModel, viewTri, rd);
        controllerTri.playGame();
        break;
      default:
        throw new RuntimeException("Cannot start game");
    }
  }
}