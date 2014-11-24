package info.botelho.ttt;

public class TicTacToe {
    
    private GameClient currentClient;
    private GameState gameState;
    private DefaultRuleSet defaultRuleSet;
    
    public TicTacToe() {
        defaultRuleSet = new DefaultRuleSet();
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
            result = defaultRuleSet.isGameOver(gameState);
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
    
    private void gameOver(Result result) {
        currentClient.gameOver(result);
        currentClient.getNextClient().gameOver(result);
    }
}
