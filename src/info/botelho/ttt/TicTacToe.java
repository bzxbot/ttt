package info.botelho.ttt;

import java.util.ArrayList;

public class TicTacToe {
    
    private GameClient currentClient;
    private GameState gameState;
    private final ArrayList<Rule> rules;

    public TicTacToe() { 
        rules = new ArrayList<>();
        rules.add(new GameOverRule());
        rules.add(new DrawRule());
    }
    
    public void start(GameClient firstClient, GameClient secondClient) {
        currentClient = firstClient;
        firstClient.setNextClient(secondClient);
        secondClient.setNextClient(firstClient);
        Player firstPlayer = currentClient.getPlayer();
        gameState = new GameState(firstPlayer);
        run();
    }
    
    private void run() {
        boolean running = true;
        Result result;
        
        do {
            turn();
            result = isGameOver();
            if (result != null) {
                running = false;
            } else {
                nextPlayer();
            }
        } while (running);
        
        gameOver(result);
    }
    
    private void turn() {
        GameInput gameInput;
        
        currentClient.update(gameState);
        
        do {
            gameInput = currentClient.getInput(gameState);
        } while (!isInputValid(gameInput));
        
        gameState.getBoard().setSymbolAt(gameInput.getRow(), gameInput.getColumn(), currentClient.getPlayer());
    }
    
    private void nextPlayer() {
        currentClient = currentClient.getNextClient();
        
        gameState = new GameState(currentClient.getPlayer(), gameState.getBoard());
    }
    
    private boolean isInputValid(GameInput gameInput) {
        return gameState.getBoard().getSymbolAtPosition(gameInput.getRow(), gameInput.getColumn()) == GameSymbol.Blank;
    }
    
    private Result isGameOver() {
        for(Rule rule : rules) {
            Result result = rule.check(gameState);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
    
    private void gameOver(Result result) {
    }
}
