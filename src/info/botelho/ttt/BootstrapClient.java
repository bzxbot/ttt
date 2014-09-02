package info.botelho.ttt;

public class BootstrapClient {
    public static void main(String[] args) {
        HumanConsoleClient humanConsoleClient = new HumanConsoleClient(new Player('X'));
        AIClient aiClient = new AIClient(new Player('O'));
        new TicTacToe().start(humanConsoleClient, aiClient);
    }
}
