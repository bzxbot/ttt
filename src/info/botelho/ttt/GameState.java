/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class GameState {
    private Board board;
    private Player currentPlayer;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public GameState(Player currentPlayer) {
        this.board = new Board();
        this.currentPlayer = currentPlayer;
    }
    
    public GameState(Player currentPlayer, Board board) {
        this.board = board;
        this.currentPlayer = currentPlayer;
    }
    
    public Board getBoard() {
        return board;
    }
}
