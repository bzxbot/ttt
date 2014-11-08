/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class AIClient extends GameClient {

    Player player;
    
    public AIClient(Player player) {
        this.player = player;
    }
    
    public GameInput getInput(GameState gameState) {
        return MinimaxAgent.getInput(gameState);
    }

    public void update(GameState state) {
    }

    public Player getPlayer() {
        return player;
    }
}
