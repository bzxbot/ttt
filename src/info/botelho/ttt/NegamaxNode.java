/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.botelho.ttt;

import java.util.ArrayList;

/**
 *
 * @author Bernardo
 */
public class NegamaxNode {
    public ArrayList<NegamaxNode> siblings;
    
    private Board board;
    private int row;
    private int column;
    
    public NegamaxNode(Board board, int row, int column) {
        this.board = board;
        this.row = row;
        this.column = column;
    }
    
    public NegamaxNode(Board board) {
        this.board = board;
    }
    
    public Board getBoard() {
        return this.board;
    }
    
    public void addSibling(NegamaxNode node) {
        siblings.add(node);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
