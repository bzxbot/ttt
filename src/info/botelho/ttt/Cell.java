package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class Cell {
    private GameSymbol symbol;
    
    public Cell(GameSymbol symbol) {
        this.symbol = symbol;
    }
    
    public GameSymbol getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(GameSymbol symbol) {
        this.symbol = symbol;
    }
}