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

    private Player player;
    private NegamaxAgent negamaxAgent;
    
    public AIClient(Player player) {
        this.player = player;
    }
    
    public void gameOver(Result result) {
    }
    
    public GameInput getInput(GameState gameState) {
        return negamaxAgent.getInput(gameState);
    }

    public void update(GameState state) {
    }

    public Player getPlayer() {
        return player;
    }
}
