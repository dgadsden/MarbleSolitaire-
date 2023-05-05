package cs3500.marblesolitaire.controller;

/**
 * This interface represents operations that should be offered by
 * a controller for the Marble solitaire game.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire.
   *
   * @throws IllegalArgumentException if the controller is unable to successfully
   *                                  read input or transmit output
   */
  void playGame() throws IllegalArgumentException;

}
