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

    @Override
    public Result check(GameState gameState) {
        Board board = gameState.getBoard();
        
        Player firstPlayer = gameState.getCurrentPlayer();
        Player secondPlayer = firstPlayer.getNextPlayer();
        
        if (isGameOver(board, firstPlayer.getSymbol())) {
            return new Result(firstPlayer);
        }
        
        if (isGameOver(board, secondPlayer.getSymbol())) {
            return new Result(secondPlayer);
        }
        
        return null;
    }
    
    private boolean isGameOver(Board board, GameSymbol gameSymbol) {
        for (int i = 0; i < 3; i++) {
            if (board.getSymbolAtPosition(i, 0) == gameSymbol &&
                board.getSymbolAtPosition(i, 1) == gameSymbol &&
                board.getSymbolAtPosition(i, 2) == gameSymbol)
                    return true;
        }
        
        for (int i = 0; i < 3; i++) {
            if (board.getSymbolAtPosition(0, i) == gameSymbol &&
                board.getSymbolAtPosition(1, i) == gameSymbol &&
                board.getSymbolAtPosition(2, i) == gameSymbol)
                    return true;
        }
        
        if (board.getSymbolAtPosition(0, 0) == gameSymbol &&
            board.getSymbolAtPosition(1, 1) == gameSymbol &&
            board.getSymbolAtPosition(2, 2) == gameSymbol)
                    return true;
    
        if (board.getSymbolAtPosition(2, 0) == gameSymbol &&
            board.getSymbolAtPosition(1, 1) == gameSymbol &&
            board.getSymbolAtPosition(0, 2) == gameSymbol)
                    return true;
        
        return false;
    }
    
}
