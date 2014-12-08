/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class NegamaxAgent {
    
    private final DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
    
    public GameInput getInput(GameState gameState) throws InvalidGameInputException {
        Player currentPlayer = gameState.getCurrentPlayer();
        NegamaxNode root = new NegamaxNode(gameState.getBoard());
        generateTree(root, gameState.getCurrentPlayer());
        NegamaxResult result = negamax(root, currentPlayer, 1);
        GameInput gameInput = new GameInput();
        gameInput.setInput(result.getRow(), result.getColumn());
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
        GameState gameState = new GameState(max, node.getBoard());
        Result result = defaultRuleSet.isGameOver(gameState);
        if (result != null) {
            return new NegamaxResult(gameScore(gameState, result, max) * color);
        }
        NegamaxResult finalResult = new NegamaxResult();
        finalResult.setScore(Integer.MIN_VALUE);
        for (NegamaxNode sibling : node.getSiblings()) {
            NegamaxResult negamaxResult = negamax(sibling, max, -color);
            int value = -negamaxResult.getScore();
            if (value > finalResult.getScore()) {
                finalResult.setScore(value);
                finalResult.setRow(sibling.getRow());
                finalResult.setColumn(sibling.getColumn());
            }
        }
        return finalResult;
    }
    
    private int gameScore(GameState gameState, Result result, Player max) {
        if (result.getWinner() == null) 
            return 0;
        if (result.getWinner().getSymbol() == max.getSymbol())
            return 1;
        return -1;
    }
}
