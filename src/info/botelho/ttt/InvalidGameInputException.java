/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class InvalidGameInputException extends Exception{
    private static final String MESSAGE = "Invalid row or column.";
    
    public InvalidGameInputException() {
        super(MESSAGE);
    }
}
