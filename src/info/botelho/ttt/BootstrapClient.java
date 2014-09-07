package info.botelho.ttt;

public class BootstrapClient {
    public static void main(String[] args) {
        HumanConsoleClient humanConsoleClient = new HumanConsoleClient(new Player(GameSymbol.X));
        AIClient aiClient = new AIClient(new Player(GameSymbol.O));
        new TicTacToe().start(humanConsoleClient, aiClient);
    }
}
