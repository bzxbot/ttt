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
public class NegamaxAgent {
    
    private final DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
    
    public GameInput getInput(GameState gameState) {
        BoardTreeNode boardTreeNode = new BoardTreeNode(-1, -1, null, gameState.getBoard());
        Player currentPlayer = gameState.getCurrentPlayer();
        Player nextPlayer = gameState.getCurrentPlayer().getNextPlayer();
        NegamaxNode root = new NegamaxNode(gameState.getBoard());
        generateTree(root, gameState.getCurrentPlayer());
        NegamaxResult result = negamax(root, currentPlayer, 1);
        GameInput gameInput = new GameInput();
        try {
            gameInput.setInput(result.getRow(), result.getColumn());
        } catch (InvalidGameInputException ex) {
            Logger.getLogger(NegamaxAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gameInput;
    }
    
    private void generateTree(NegamaxNode node, Player currentPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (node.getBoard().getSymbolAtPosition(i, j) == GameSymbol.Blank) {
                    Board newBoard = new Board(node.getBoard().getGrid());
                    newBoard.setSymbolAt(i, j, currentPlayer);
                    NegamaxNode newNode = new NegamaxNode(newBoard, i, j);
                    node.addSibling(newNode);
                    generateTree(newNode, currentPlayer.getNextPlayer());
                }
            }
        }
    }
    
    private NegamaxResult negamax(NegamaxNode node, Player max, int color) {
        Result result = defaultRuleSet.isGameOver(new GameState(max, node.getBoard()));
        if (result != null) {
            return new NegamaxResult(gameScore(result, max) * color);
        }
        NegamaxResult finalResult = new NegamaxResult();
        finalResult.setScore(Integer.MIN_VALUE);
        for (NegamaxNode sibling : node.siblings) {
            NegamaxResult negamaxResult = negamax(sibling, max.getNextPlayer(), -color);
            int value = -negamaxResult.getScore();
            if (value > finalResult.getScore()) {
                finalResult.setScore(value);
                finalResult.setRow(sibling.getRow());
                finalResult.setColumn(sibling.getColumn());
            }
        }
        return finalResult;
    }
    
    private int gameScore(Result result, Player max) {
        if (result.getWinner() == max)
            return 1;
        if (result.getWinner() != null)
            return -1;
        return 0;
    }
}
