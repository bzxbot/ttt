/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

import java.util.Scanner;

/**
 *
 * @author Bernardo
 */
public class HumanConsoleClient extends GameClient {
    private Player player;
    private Scanner scanner;
    
    public HumanConsoleClient(Player player) {
        this.player = player;
        scanner = new Scanner(System.in);
    }
    
    public GameInput getInput(GameState gameState) {
        System.out.println("Enter row and column: ");
        return new GameInput(readNextInt() - 1, readNextInt() - 1);
    }
    
    private int readNextInt() {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
		return scanner.nextInt();
                } else {
		scanner.next();
            }
	}
        
        return -1;
    }

    public void update(GameState state) {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print(state.getBoard().getSymbolAtPosition(i,j) + " | ");
            }
            System.out.println(state.getBoard().getSymbolAtPosition(i,2));
            System.out.println("----------");
        }
        
        for(int i = 0; i < 2; i++) {
            System.out.print(state.getBoard().getSymbolAtPosition(2,i) + " | ");
        }
        
        System.out.println(state.getBoard().getSymbolAtPosition(2, 2));
        System.out.println("");
        System.out.println("");
    }

    public Player getPlayer() {
        return player;
    }
}
