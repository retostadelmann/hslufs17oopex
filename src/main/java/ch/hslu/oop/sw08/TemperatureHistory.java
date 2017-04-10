/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import ch.hslu.demo.Helpers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author reto.stadelmann
 */
public final class TemperatureHistory {
    
    private final ArrayList<Temperature> temperatures;
    
    /**
     * Instantiates a new temperature history object.
     */
    public TemperatureHistory(){
        this.temperatures = new ArrayList<>();
    }
    
    /**
     * Adds a new temperature to the temperature history.
     * @param temp The temperature to add.
     */
    public void add(Temperature temp){
        Helpers.checkNullArgument(temp, "temp");
        
        this.temperatures.add(temp);
    }
    
    /**
     * Clears the current history entries.
     */
    public void clear(){
        this.temperatures.clear();
    }
    
    /**
     * Returns the amount of stored temperatures in this objects history.
     * @return The amount of temperature entries.
     */
    public int getCount(){
        return this.temperatures.size();
    }
    
    /**
     * Returns the maximal value in the history.
     * @return The temperature with the highest value.
     * @throws UnsupportedOperationException
     */
    public Temperature getMaxValue(){
        if(this.getCount() == 0){
            throw new UnsupportedOperationException(
                    "There are no Temperatures stored in the history list.");
        }
        else{
            return Collections.max(this.temperatures);
        }
    }
    
    /**
     * Returns the maximal value in the history.
     * @return The temperature with the highest value.
     * @throws UnsupportedOperationException
     */
    public Temperature getMinValue(){
        if(this.getCount() == 0){
            throw new UnsupportedOperationException(
                    "There are no Temperatures stored in the history list.");
        }
        else{
            return Collections.min(this.temperatures);
        }
    }
}
