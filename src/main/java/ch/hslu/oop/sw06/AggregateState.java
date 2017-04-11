/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

/**
 *
 * @author reto.stadelmann
 */
public enum AggregateState {
    Solid("fest"),
    Liquid("flüssig"),
    Gas("gasförmig");
    
    private final String description;
    
    private AggregateState(final String description){
        this.description = description;
    }
    
    /**
     * Returns a textual representation of the state.
     * @return The state.
     */
    public String getValue(){
        return this.description;
    }
}
