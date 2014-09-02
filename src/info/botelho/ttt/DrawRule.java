/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class DrawRule extends Rule {
    
    private final String message = "Draw!";

    public Result check(GameState gameState) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameState.getBoard().getSymbolAtPosition(i, j) == Board.EmptyCell) {
                    return null;
                }
            }
        }
        
        return new Result(message);
    }
}
