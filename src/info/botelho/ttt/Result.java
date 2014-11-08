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
    private ResultType gameResult;
    
    public Result(Player winner) {
        this.winner = winner;
        this.gameResult = ResultType.PlayerWins;
    }
   
    public Result() {
        this.gameResult = ResultType.Draw;
    }
    
    public Player getWinner() {
        return winner;
    }
}
