/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bernardo
 */
public class AIClient extends GameClient {

    private final NegamaxAgent negamaxAgent = new NegamaxAgent();
    
    private final Player player;
    private GameState gameState;
    
    public AIClient(Player player) {
        this.player = player;
    }
    
    @Override
    public void gameOver(Result result) {
    }
    
    @Override
    public GameInput getInput() {
        GameInput gameInput = null;
        
        try {
            gameInput = negamaxAgent.getInput(gameState);
        } catch (InvalidGameInputException ex) {
            Logger.getLogger(AIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return gameInput;
    }

    @Override
    public void update(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
