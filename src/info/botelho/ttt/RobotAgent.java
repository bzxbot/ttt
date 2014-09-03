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
public class RobotAgent {
    
    private static GameOverRule gameOver = new GameOverRule();
    
    public static GameInput getInput(GameState gameState) {
        BoardTreeNode boardTreeNode = new BoardTreeNode(-1, -1, null, gameState.getBoard());
        MinimaxResult result = minimax(gameState.getCurrentPlayer().getSymbol(), gameState.getCurrentPlayer().getSymbol(), boardTreeNode);
        GameInput gameInput = new GameInput();
        try {
            gameInput.setInput(result.row, result.col);
        } catch (InvalidGameInputException ex) {
            Logger.getLogger(RobotAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gameInput;
    }

    private static MinimaxResult minimax(char playerSymbol, char currentSymbol, BoardTreeNode boardTreeNode) {
        int bestScore;
        int bestRow = -1, bestCol = -1;
        char nextSymbol;

        if (currentSymbol == playerSymbol) {
            bestScore = Integer.MIN_VALUE;
        } else {
            bestScore = Integer.MAX_VALUE;
        }
        
        if (currentSymbol == 'X') {
            nextSymbol = 'O';
        } else {
            nextSymbol = 'X';
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardTreeNode.board.getSymbolAtPosition(i, j) == Board.EmptyCell) {
                    Board newBoard = new Board(boardTreeNode.board.board);
                    newBoard.setSymbolAt(i, j, currentSymbol);
                    boardTreeNode.addSibling(i, j, newBoard);
                }
            }
        }

//        if (boardTreeNode.siblings.isEmpty() || 
//                gameOver.check(gameState) != null || 
//                gameOver.check(gameState) != null) {
//            if (isGameOver(boardTreeNode.board, playerSymbol) != null) {
//                bestScore = 1;
//            } else if (isGameOver(boardTreeNode.board, otherSymbol) != null) {
//                bestScore = -1;
//            } else {
//                bestScore = 0;
//            }
//        } else {
//            for (BoardTreeNode sibling : boardTreeNode.siblings) {
//                MinimaxResult result = minimax(playerSymbol, nextSymbol ,sibling);
//                if (currentSymbol == playerSymbol) {
//                    if (result.score > bestScore) {
//                        bestScore = result.score;
//                        bestRow = sibling.row;
//                        bestCol = sibling.col;
//                    }
//                } else {
//                    if (result.score < bestScore) {
//                        bestScore = result.score;
//                        bestRow = sibling.row;
//                        bestCol = sibling.col;
//                    }
//                }
//            }
//        }

        return new MinimaxResult(bestScore, bestRow, bestCol);
    }
}
