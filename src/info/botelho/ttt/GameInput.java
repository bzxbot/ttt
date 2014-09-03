/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class GameInput {
    private int row;
    private int column;
    
    public void setInput(int row, int column) throws InvalidGameInputException {
        if (row > 2 || row < 0) {
            throw new InvalidGameInputException();
        }
        if (column > 2 || column < 0) {
            throw new InvalidGameInputException();
        }
        this.row = row;
        this.column = column;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getColumn() {
        return this.column;
    }
}
