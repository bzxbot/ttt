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
//        return RobotAgent.getInput(gameState.getCurrentPlayer().getSymbol(), gameState.getBoard());
        return null;
    }

    public void update(GameState state) {
    }

    public Player getPlayer() {
        return player;
    }
}
