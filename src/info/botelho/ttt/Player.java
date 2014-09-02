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
    private char symbol;
    private Player nextPlayer;  
    
    public Player(char symbol) {
        this.symbol = symbol;
    }
    
    public char getSymbol() {
        return symbol;
    }
    
    public Player getNextPlayer() {
        return nextPlayer;
    }
    
    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }
    
    public GameClient getGameClient() {
        return null;
    }
}
