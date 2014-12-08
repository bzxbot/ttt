/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.botelho.ttt;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bernardo
 */
public class NegamaxAgentTest {
    
    public NegamaxAgentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInput method, of class NegamaxAgent.
     * @throws info.botelho.ttt.InvalidGameInputException
     */
    @Test
    public void testGetInputWiningMoveX() throws InvalidGameInputException {
        char[][] grid = {{'X', ' ', 'X'},
                         {'O', ' ', 'O'},
                         {' ', 'O', 'O'}};
        Player firstPlayer = new Player(GameSymbol.X);
        Player secondPlayer = new Player(GameSymbol.O);
        firstPlayer.setNextPlayer(secondPlayer);
        secondPlayer.setNextPlayer(firstPlayer);
        GameState gameState = new GameState(firstPlayer, new Board(grid));
        NegamaxAgent instance = new NegamaxAgent();
        GameInput expResult = new GameInput();
        expResult.setInput(0, 1);
        GameInput result = instance.getInput(gameState);
        assertEquals(expResult.getRow(), result.getRow());
        assertEquals(expResult.getColumn(), result.getColumn());
    }
    
    /**
     * Test of getInput method, of class NegamaxAgent.
     * @throws info.botelho.ttt.InvalidGameInputException
     */
    @Test
    public void testGetInputBlockingWinningMove() throws InvalidGameInputException {
        char[][] grid = {{' ', ' ', 'O'},
                         {'O', 'X', 'O'},
                         {'X', 'O', 'X'}};
        Player firstPlayer = new Player(GameSymbol.O);
        Player secondPlayer = new Player(GameSymbol.X);
        firstPlayer.setNextPlayer(secondPlayer);
        secondPlayer.setNextPlayer(firstPlayer);
        GameState gameState = new GameState(firstPlayer, new Board(grid));
        NegamaxAgent instance = new NegamaxAgent();
        GameInput expResult = new GameInput();
        expResult.setInput(0, 0);
        GameInput result = instance.getInput(gameState);
        assertEquals(expResult.getRow(), result.getRow());
        assertEquals(expResult.getColumn(), result.getColumn());
    }
    
    /**
     * Test of getInput method, of class NegamaxAgent.
     * @throws info.botelho.ttt.InvalidGameInputException
     */
    @Test
    public void testGetInputMakeWinningMove() throws InvalidGameInputException {
        char[][] grid = {{'X', ' ', 'O'},
                         {'O', 'X', 'O'},
                         {'X', 'X', ' '}};
        Player firstPlayer = new Player(GameSymbol.O);
        Player secondPlayer = new Player(GameSymbol.X);
        firstPlayer.setNextPlayer(secondPlayer);
        secondPlayer.setNextPlayer(firstPlayer);
        GameState gameState = new GameState(firstPlayer, new Board(grid));
        NegamaxAgent instance = new NegamaxAgent();
        GameInput expResult = new GameInput();
        expResult.setInput(2, 2);
        GameInput result = instance.getInput(gameState);
        System.out.println(result.getRow());
        System.out.println(result.getColumn());
        assertEquals(expResult.getRow(), result.getRow());
        assertEquals(expResult.getColumn(), result.getColumn());
    }
    
    /**
     * Test of getInput method, of class NegamaxAgent.
     * @throws info.botelho.ttt.InvalidGameInputException
     */
    @Test
    public void testGetInputDefend() throws InvalidGameInputException {
        char[][] grid = {{'X', ' ', 'O'},
                         {' ', 'X', ' '},
                         {' ', ' ', ' '}};
        Player firstPlayer = new Player(GameSymbol.O);
        Player secondPlayer = new Player(GameSymbol.X);
        firstPlayer.setNextPlayer(secondPlayer);
        secondPlayer.setNextPlayer(firstPlayer);
        GameState gameState = new GameState(firstPlayer, new Board(grid));
        NegamaxAgent instance = new NegamaxAgent();
        GameInput expResult = new GameInput();
        expResult.setInput(2, 2);
        GameInput result = instance.getInput(gameState);
        System.out.println(result.getRow());
        System.out.println(result.getColumn());
        assertEquals(expResult.getRow(), result.getRow());
        assertEquals(expResult.getColumn(), result.getColumn());
    }
}
