/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

import java.util.Objects;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author reto.stadelmann
 */
@Immutable
public abstract class Element {
    public enum TemperatureType{
        Kelvin,
        Celsius,
        Farenheit
    }
    
    // member
    protected String ElementName = "Element";
    protected final double defaultTemparature = 20.00;
    protected final double kelvinOffset = 273.15;
    protected double tempCels;

    /**
     * Constructor for a new Element object using the initial temperature.
     */
    public Element()
    {
        // initialise instance variables
        this.setTemperature(defaultTemparature);
    }
    
    /**
     * Constructor for a new Element object with an initial temperature.
     * @param temperature the initial temperature
     */
    public Element(final double temperature){
        this.setTemperature(temperature);
    }

    /*
     * Get the current temparature in the given type.
     */
    public double getTemparature(TemperatureType type)
    {
        switch(type){
            case Celsius:
                return this.tempCels;
            case Kelvin:
                return this.tempCels + kelvinOffset;
            case Farenheit:
                return (this.tempCels * 9.0/5.0) + 32;
            default: // throw error
                return -1;
        } 
    }
    
    /*
     * Set a new absolute temparature.
     */
    public void setTemperature(final double newTempCelsius){
        if(newTempCelsius < -273.15){
            throw new IllegalArgumentException("New Temp cannot be less than -273.15");
        }
        
        this.tempCels = newTempCelsius;
    }
    
    /*
     * Set a new temparature relative to the currently set temparature.
     */
    public void setTemperatureRelative(final double relativeChange){
        this.tempCels += relativeChange;
    }
    
    @Override
    public String toString(){
        return this.ElementName;
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
        return Objects.equals(this.ElementName, other.ElementName);
    }
    
    /*
    * Overrides the default method.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.ElementName);
    }
    
    public abstract String getElementState(final String element);
    public abstract String getElementName();
}
