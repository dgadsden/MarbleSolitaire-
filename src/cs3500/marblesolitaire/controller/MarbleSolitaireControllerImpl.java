package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This class is the controller for the Marble Solitaire game. It uses a readable to track the
 * inputs and appendable to return the outputs of the game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable input;
  /**
   * Constructor that instantiates a controller with a model, view and readable input.
   *
   * @param model a MarbleSolitaireModel for the marble solitaire
   * @param view  a textual representation of the game
   * @param input a readable input
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable input) throws IllegalArgumentException {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("Given null model, view or input.");
    }
    this.model = model;
    this.view = view;
    this.input = input;
  }


  /**
   * This method renders a game of marble solitaire util the game is either quit qith "q" or if
   * the game is over .
   *
   * @throws IllegalArgumentException if there is an invalid input or the message cannot be
   *                                  transmitted.
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner sc = new Scanner(this.input);
    boolean isQuitGame = false;

    while (!model.isGameOver()) {
      stateAndScore();

      ArrayList<Integer> values = new ArrayList<Integer>();
      while (values.size() != 4) {
        String next;
        try {
          next = sc.next();
        } catch (NoSuchElementException e) {
          try {
            next = sc.nextLine();
          } catch (NoSuchElementException ee) {
            throw new IllegalStateException("Four or more moves needed.");
          }
          throw new IllegalStateException("Four or more moves needed.");
        }

        try {
          if (next.equalsIgnoreCase("q")) {
            isQuitGame = true;
            break;
          } else if (Integer.parseInt(next) > 0) {
            values.add(Integer.parseInt(next) - 1);
            continue;
          }
        } catch (NumberFormatException ne) {
          try {
            view.renderMessage("Value given is unexpected.\n");
          } catch (IOException e) {
            throw new IllegalStateException("Cannot read input or transmit output.");
          }
        }
      }


      if (!isQuitGame) {
        try {
          model.move(values.get(0), values.get(1), values.get(2), values.get(3));
        } catch (IllegalArgumentException e) {
          try {
            view.renderMessage("Invalid move. Play again. Must be a valid move or 'q' for quit.\n");
          } catch (IOException ee) {
            throw new IllegalStateException("Cannot read input or transmit output.");
          }
        }
      } else {
        break;
      }
    }

    if (model.isGameOver()) {
      this.gameOver();
    }

  }


  /**
   * This method render the quit state of the game.
   *
   * @throws IllegalStateException when there is an error transmitting the game state.
   */
  private void quitGame() throws IllegalStateException {
    try {
      view.renderMessage("Game quit!\n");
      view.renderMessage("State of game when quit:\n");
      this.stateAndScore();

    } catch (IOException e) {
      throw new IllegalStateException("Error in transmitting quit game state.");
    }
  }

  /**
   * This method renders the end message and state of the game.
   *
   * @throws IllegalStateException if there is an error transmitting the state.
   */
  private void gameOver() throws IllegalStateException {
    try {
      view.renderMessage("Game over!\n");
      this.stateAndScore();

    } catch (IOException e) {
      throw new IllegalStateException("Error in transmitting final game state.");
    }
  }

  /**
   * This method renders the current state and score of game.
   *
   * @throws IllegalStateException if there is an error transmitting the state.
   */
  private void stateAndScore() throws IllegalStateException {
    try {
      view.renderBoard();
      view.renderMessage("\n");
      view.renderMessage("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Error in transmitting final game state.");
    }
  }
}
