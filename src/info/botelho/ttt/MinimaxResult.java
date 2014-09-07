/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class MinimaxResult {
    public int score;
    public int row;
    public int col;
    
    public MinimaxResult(int score, int row, int col) {
        this.score = score;
        this.row = row;
        this.col = col;
    }
    
}
