/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.botelho.ttt;

/**
 *
 * @author Bernardo
 */
public class Result {
    private String resultMessage;
    
    public Result(String resultMessage) {
        this.resultMessage = resultMessage;
    }
    
    public String getMessage() {
        return resultMessage;
    }
}
