/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class NegamaxResult {
    
    private int score;
    private int column;
    private int row;
    
    public NegamaxResult() {
    }
    
    public NegamaxResult(int score, int row, int column) {
        this.score = score;
        this.column = column;
        this.row = row;
    }
    
    public NegamaxResult(int score) {
        this.score = score;
        this.column = -1;
        this.row = -1;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getScore() {
        return score;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    
    
}
