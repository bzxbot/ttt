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
public class DefaultRuleSet {
    
    private final ArrayList<Rule> rules;
    
    public DefaultRuleSet() { 
        rules = new ArrayList<>();
        rules.add(new GameOverRule());
        rules.add(new DrawRule());
    }
    
    
    public Result isGameOver(GameState gameState) {
        for(Rule rule : rules) {
            Result result = rule.check(gameState);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
