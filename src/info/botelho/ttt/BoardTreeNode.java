/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

import java.util.ArrayList;

/**
 *
 * @author Bernardo
 */
public class BoardTreeNode {
    public Board board;
    public BoardTreeNode father;
    public ArrayList<BoardTreeNode> siblings;
    public int score = 0;
    public boolean gameOver = false;
    
    public int row;
    public int col;
    
    public BoardTreeNode(int row, int col, BoardTreeNode father, Board board) {
        this.board = board;
        this.father = father;
        this.row = row;
        this.col = col;
        siblings = new ArrayList<BoardTreeNode>();
    }
    
    public void addSibling(int row, int col, Board board) {
        siblings.add(new BoardTreeNode(row, col, this, board));
    }
}
