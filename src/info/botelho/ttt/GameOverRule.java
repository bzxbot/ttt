/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class GameOverRule extends Rule {

    public Result check(GameState gameState) {
        Board board = gameState.getBoard();
        
        char lastPlayerSymbol = gameState.getCurrentPlayer().getSymbol();
        
        for (int i = 0; i < 3; i++) {
            if (board.getSymbolAtPosition(i, 0) == lastPlayerSymbol &&
                board.getSymbolAtPosition(i, 1) == lastPlayerSymbol &&
                board.getSymbolAtPosition(i, 2) == lastPlayerSymbol)
                    return new Result(lastPlayerSymbol + " wins!");
        }
        
        for (int i = 0; i < 3; i++) {
            if (board.getSymbolAtPosition(0, i) == lastPlayerSymbol &&
                board.getSymbolAtPosition(1, i) == lastPlayerSymbol &&
                board.getSymbolAtPosition(2, i) == lastPlayerSymbol)
                    return new Result(lastPlayerSymbol + " wins!");
        }
        
        if (board.getSymbolAtPosition(0, 0) == lastPlayerSymbol &&
            board.getSymbolAtPosition(1, 1) == lastPlayerSymbol &&
            board.getSymbolAtPosition(2, 2) == lastPlayerSymbol)
                    return new Result(lastPlayerSymbol + " wins!");
    
        if (board.getSymbolAtPosition(2, 0) == lastPlayerSymbol &&
            board.getSymbolAtPosition(1, 1) == lastPlayerSymbol &&
            board.getSymbolAtPosition(0, 2) == lastPlayerSymbol)
                    return new Result(lastPlayerSymbol + " wins!");
        
        return null;
    }
    
}
