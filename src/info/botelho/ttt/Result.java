/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class Result {
    private Player winner;
    
    public Result() {
    }
    
    public Result(Player winner) {
        this.winner = winner;
    }
    
    public Player getWinner() {
        return winner;
    }
}