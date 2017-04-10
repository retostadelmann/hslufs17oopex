/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import java.util.Objects;
import jdk.nashorn.internal.ir.annotations.Immutable;


/**
 *
 * @author reto.stadelmann
 */
@Immutable
public final class Temperature implements Comparable<Temperature> {
    public enum TemperatureType{
        Kelvin,
        Celsius,
        Farenheit
    }
    
    static final double KELVIN_OFFSET = 273.15;
    
    // member 
    protected String ElementName = "Element";
    protected final double defaultTemparature = 20.00;  
    protected double tempCels;

    /**
     * Constructor for a new Element object using the initial temperature.
     */
    public Temperature()
    {
        // initialise instance variables
        this.setTemperature(defaultTemparature);
    }
    
    /**
     * Constructor for a new Element object with an initial temperature.
     * @param temperature the initial temperature
     */
    public Temperature(final double temperature){
        this.setTemperature(temperature);
    }
    
    /**
     * Converts the given temperature to Kelvin.
     * @param celsiusTemperature The temperature to convert.
     * @return The converted temperature in Kelvin.
     */
    public static double convertCelsiusToKelvin(final double celsiusTemperature)
    {
        if(celsiusTemperature < (KELVIN_OFFSET * -1)){
            throw new IllegalArgumentException("New Temp cannot be less than -273.15");
        }
        
        return celsiusTemperature + KELVIN_OFFSET;
    }

    /**
     * Gets the current temperature in the given type.
     * @param type The temperature type to return the value in.
     * @return The current temperature in the selected type.
     */
    public double getTemparature(TemperatureType type)
    {
        switch(type){
            case Celsius:
                return this.tempCels;
            case Kelvin:
                return convertCelsiusToKelvin(this.tempCels);
            case Farenheit:
                return (this.tempCels * 9.0/5.0) + 32;
            default: // throw error
                return -1;
        } 
    }
    
    /**
     * Set a new absolute temperature.
     * @param newTempCelsius The temperature to set.
     */
    public void setTemperature(final double newTempCelsius){
        if(newTempCelsius < (KELVIN_OFFSET * -1)){
            throw new IllegalArgumentException("New Temp cannot be less than -273.15");
        }
        
        this.tempCels = newTempCelsius;
    }
    
    /**
     * Set a new temperature relative to the currently set temperature.
     * @param relativeChange The relative temperature change in Celsius.
     */
    public void setTemperatureRelative(final double relativeChange){
        this.tempCels += relativeChange;
    }
    
    @Override
    public final boolean equals(final Object obj){
         if (obj == this) {
            return true;
        }

        if (!(obj instanceof Temperature)) {
            return false;
        }

        final Temperature other = (Temperature) obj;
        return Objects.equals(this.tempCels, other.tempCels);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.tempCels, this.tempCels);
    }
    
    @Override
    public int compareTo(Temperature other) {
       return Double.compare(this.tempCels, other.tempCels);
    }
}
