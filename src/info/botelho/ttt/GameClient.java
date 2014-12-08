/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public abstract class GameClient {
    public abstract GameInput getInput();
    public abstract void update(GameState gameState);
    public abstract void gameOver(Result result);

    private GameClient next;
    
    public GameClient getNextClient() {
        return next;
    }
    
    public void setNextClient(GameClient next) {
        this.next = next;
    }
    
    public abstract Player getPlayer();
}
