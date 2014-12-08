package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class BoardCell {
    private GameSymbol symbol;
    
    public BoardCell(GameSymbol symbol) {
        this.symbol = symbol;
    }
    
    public GameSymbol getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(GameSymbol symbol) {
        this.symbol = symbol;
    }
}