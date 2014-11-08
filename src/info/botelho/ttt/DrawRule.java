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
    
    public Result check(GameState gameState) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameState.getBoard().getSymbolAtPosition(i, j) == GameSymbol.Blank) {
                    return null;
                }
            }
        }
        
        return new Result();
    }
}
