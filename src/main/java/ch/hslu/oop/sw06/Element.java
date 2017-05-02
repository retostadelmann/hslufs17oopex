/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

import ch.hslu.oop.sw08.*;
import ch.hslu.oop.sw10.TemperatureException;
import java.util.EnumMap;
import java.util.Objects;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author reto.stadelmann
 */
@Immutable
public abstract class Element{
    
    // member
    protected String elementName = "Element";
    protected Temperature temperature;
    protected EnumMap<AggregateState, Double> stateSwitchPoints;

    /**
     * Constructor for a new Element object using the initial temperature.
     */
    public Element()
    {
        this.temperature = Temperature.createFromCelsius(0);
        this.stateSwitchPoints = new EnumMap<>(AggregateState.class);
    }
    
    /**
     * Constructor for a new Element object with an initial temperature.
     * @param temperature the initial temperature
     */
    public Element(final double temperature){
        this.stateSwitchPoints = new EnumMap<>(AggregateState.class);
        this.temperature = Temperature.createFromCelsius(temperature);
    }

    /**
     * Get the current temperature in the given type.
     * @param type The temperature type.
     * @return The temperature.
     */
    public double getTemparature(TemperatureType type) throws TemperatureException
    {
       return this.temperature.getTemparature(type);
    }
    
    /**
     * Set a new absolute temperature.
     * @param newTempCelsius The new temperature.
     */
    public void setTemperature(final double newTempCelsius){
        this.temperature.setTemperature(newTempCelsius);
    }
    
    /**
     * Set a new temperature relative to the currently set temperature.
     * @param relativeChange The relative change.
     */
    public void setTemperatureRelative(final double relativeChange){
        this.temperature.setTemperatureRelative(relativeChange);
    }
    
    /**
     * Get the current Element State in text form.
     * @return 
     */
    public String getElementState() throws TemperatureException
    {
         return this.getTemperatureStateString(this.getCurrentState());
    }
    
    /**
     * Gets the current element state.
     * @return The aggregate state the element is currently in.
     * @throws TemperatureException 
     */
    protected AggregateState getCurrentState() throws TemperatureException
    {
        if (this.temperature.getTemparature(TemperatureType.Celsius) < this.stateSwitchPoints.get(AggregateState.Solid)) {
            return AggregateState.Solid;
        } else if (this.temperature.getTemparature(TemperatureType.Celsius) < this.stateSwitchPoints.get(AggregateState.Liquid)) {
            return AggregateState.Liquid;
        } else {
            return AggregateState.Gas;
        }
    }
    
    /**
     * Gets the string as a temperature.
     * @param state
     * @return
     * @throws TemperatureException 
     */
    protected String getTemperatureStateString(AggregateState state) throws TemperatureException
    {
        return String.format(
                "%s ist bei %s Grad Celsius %s", 
                this.elementName, 
                this.temperature.getTemparature(TemperatureType.Celsius), 
                state.getValue());
    }
    
    @Override
    public String toString(){
        return this.elementName;
    }
    
    @Override
    public final boolean equals(Object obj){
         if (obj == this) {
            return true;
        }

        if (!(obj instanceof Element)) {
            return false;
        }
        
         final Element other = (Element) obj;
        return Objects.equals(this.elementName, other.elementName);
    }
    
    @Override
    public final int hashCode() {
        return Objects.hash(this.elementName);
    }
    
    /**
     * Gets the currents element name.
     * @return The element name.
     */
    public abstract String getElementName();
    
    /**
     * Sets the state switching points for the current element.
     */
    protected abstract void setElementStateSwitchingPoints();
}
