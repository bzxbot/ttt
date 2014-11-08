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
        
        Player currentPlayer = gameState.getCurrentPlayer();
        GameSymbol currentPlayerSymbol = currentPlayer.getSymbol();
        
        for (int i = 0; i < 3; i++) {
            if (board.getSymbolAtPosition(i, 0) == currentPlayerSymbol &&
                board.getSymbolAtPosition(i, 1) == currentPlayerSymbol &&
                board.getSymbolAtPosition(i, 2) == currentPlayerSymbol)
                    return new Result(currentPlayer);
        }
        
        for (int i = 0; i < 3; i++) {
            if (board.getSymbolAtPosition(0, i) == currentPlayerSymbol &&
                board.getSymbolAtPosition(1, i) == currentPlayerSymbol &&
                board.getSymbolAtPosition(2, i) == currentPlayerSymbol)
                    return new Result(currentPlayer);
        }
        
        if (board.getSymbolAtPosition(0, 0) == currentPlayerSymbol &&
            board.getSymbolAtPosition(1, 1) == currentPlayerSymbol &&
            board.getSymbolAtPosition(2, 2) == currentPlayerSymbol)
                    return new Result(currentPlayer);
    
        if (board.getSymbolAtPosition(2, 0) == currentPlayerSymbol &&
            board.getSymbolAtPosition(1, 1) == currentPlayerSymbol &&
            board.getSymbolAtPosition(0, 2) == currentPlayerSymbol)
                    return new Result(currentPlayer);
        
        return null;
    }
    
}
