/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.botelho.games.ttt;

import info.botelho.ttt.BoardTreeNode;
import info.botelho.ttt.Board;
import info.botelho.ttt.MinimaxResult;
import info.botelho.ttt.MinimaxAgent;
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
public class MinimaxAgentTest {
    
    public MinimaxAgentTest() {
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
     * Test of generateSubTree method, of class RobotInput.
     */
    @Test
    public void testGenerateSubTree() {
        System.out.println("generateSubTree");
        char b[][] = {{ 'X', 'O', 'X'},
                      { ' ', 'O', ' '},
                      { 'O', 'X', 'X'}};
        char robotSymbol = 'O';
        char currentSymbol = 'O';
        BoardTreeNode boardTreeNode = new BoardTreeNode(-1, -1, null, new Board(b));
        MinimaxResult expResult = new MinimaxResult(0, 1, 2);
//        MinimaxResult result = RobotAgent.generateSubTree(robotSymbol, currentSymbol, boardTreeNode);
//        assertEquals(expResult.col, result.col);
//        assertEquals(expResult.row, result.row);
    }
    
    @Test
    public void testGenerateSubTree2() {
        System.out.println("generateSubTree");
        char b[][] = {{ 'X', 'X', 'O'},
                      { ' ', 'O', ' '},
                      { ' ', ' ', ' '}};
        char robotSymbol = 'O';
        char currentSymbol = 'O';
        BoardTreeNode boardTreeNode = new BoardTreeNode(-1, -1, null, new Board(b));
        MinimaxResult expResult = new MinimaxResult(0, 1, 2);
//        MinimaxResult result = RobotAgent.generateSubTree(robotSymbol, currentSymbol, boardTreeNode);
//        assertEquals(expResult.col, result.col);
//        assertEquals(expResult.row, result.row);
    }
    
    /**
     * Test of generateSubTree method, of class RobotInput.
     */
    @Test
    public void testIsDraw() {
        char b[][] = {{ 'X', 'O', 'X'},
                      { 'X', 'O', 'X'},
                      { 'O', 'X', 'X'}};
        Board board = new Board(b);
//        assertTrue(RobotAgent.isDraw(board));
    }
}