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
public class MinimaxAgent {
    
    private static GameOverRule gameOver = new GameOverRule();
    
    public static GameInput getInput(GameState gameState) {
        BoardTreeNode boardTreeNode = new BoardTreeNode(-1, -1, null, gameState.getBoard());
        Player currentPlayer = gameState.getCurrentPlayer();
        Player nextPlayer = gameState.getCurrentPlayer().getNextPlayer();
        MinimaxResult result = minimax(gameState, currentPlayer, nextPlayer, boardTreeNode);
        GameInput gameInput = new GameInput();
        try {
            gameInput.setInput(result.row, result.col);
        } catch (InvalidGameInputException ex) {
            Logger.getLogger(MinimaxAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gameInput;
    }

    private static MinimaxResult minimax(GameState gameState, Player max, Player min, BoardTreeNode boardTreeNode) {
        int score;
        int row = -1, col = -1;
        Player currentPlayer = gameState.getCurrentPlayer();
        
        if (currentPlayer == max) {
            score = Integer.MIN_VALUE;
        } else {
            score = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardTreeNode.board.getSymbolAtPosition(i, j) == null) {
                    Board newBoard = new Board(boardTreeNode.board.getBoardSpaces());
                    newBoard.setSymbolAt(i, j, currentPlayer);
                    boardTreeNode.addSibling(i, j, newBoard);
                }
            }
        }

        if (boardTreeNode.siblings.isEmpty() || 
                gameOver.check(gameState) != null || 
                gameOver.check(gameState) != null) {
            if (gameOver.check(gameState) != null) {
                score = 1;
            } else if (gameOver.check(gameState) != null) {
                score = -1;
            } else {
                score = 0;
            }
        } else {
            for (BoardTreeNode sibling : boardTreeNode.siblings) {
                MinimaxResult result = minimax(gameState, max, min, sibling);
                if (currentPlayer == max) {
                    if (result.score > score) {
                        score = result.score;
                        row = sibling.row;
                        col = sibling.col;
                    }
                } else {
                    if (result.score < score) {
                        score = result.score;
                        row = sibling.row;
                        col = sibling.col;
                    }
                }
            }
        }

        return new MinimaxResult(score, row, col);
    }
}
