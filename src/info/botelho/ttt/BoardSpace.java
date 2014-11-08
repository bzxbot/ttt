package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class BoardSpace {
    private GameSymbol symbol;
    
    public BoardSpace(GameSymbol symbol) {
        this.symbol = symbol;
    }
    
    public GameSymbol getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(GameSymbol symbol) {
        this.symbol = symbol;
    }
}