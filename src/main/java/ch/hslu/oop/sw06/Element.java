/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

import ch.hslu.oop.sw08.Temperature;
import java.util.Objects;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author reto.stadelmann
 */
@Immutable
public abstract class Element {
    
    // member
    protected String elementName = "Element";
    protected Temperature temperature;

    /**
     * Constructor for a new Element object using the initial temperature.
     */
    public Element()
    {
        // initialise instance variables
        this.temperature = new Temperature();
    }
    
    /**
     * Constructor for a new Element object with an initial temperature.
     * @param temperature the initial temperature
     */
    public Element(final double temperature){
        this.temperature = new Temperature(temperature);
    }

    /*
     * Get the current temparature in the given type.
     */
    public double getTemparature(Temperature.TemperatureType type)
    {
       return this.temperature.getTemparature(type);
    }
    
    /*
     * Set a new absolute temparature.
     */
    public void setTemperature(final double newTempCelsius){
        this.temperature.setTemperature(newTempCelsius);
    }
    
    /*
     * Set a new temparature relative to the currently set temparature.
     */
    public void setTemperatureRelative(final double relativeChange){
        this.temperature.setTemperatureRelative(relativeChange);
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
    
    /*
    * Overrides the default method.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.elementName);
    }
    
    public abstract AggregateState getElementState();
    public abstract String getElementName();
}
