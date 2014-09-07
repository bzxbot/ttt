/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class Player {
    private GameSymbol symbol;
    private Player nextPlayer;  
    
    public Player(GameSymbol symbol) {
        this.symbol = symbol;
    }
    
    public GameSymbol getSymbol() {
        return symbol;
    }
    
    public Player getNextPlayer() {
        return nextPlayer;
    }
    
    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }
}
