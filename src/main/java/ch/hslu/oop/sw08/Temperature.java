/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import ch.hslu.oop.sw10.TemperatureException;
import java.util.Objects;
import jdk.nashorn.internal.ir.annotations.Immutable;


/**
 *
 * @author reto.stadelmann
 */
@Immutable
public final class Temperature implements Comparable<Temperature> {
      
    static final double KELVIN_OFFSET = 273.15;
    
    // member 
    protected String ElementName = "Element";
    protected final double defaultTemparature = 20.00;  
    protected double tempCels;

    /**
     * Constructor for a new Element object using the initial temperature.
     */
    private Temperature()
    {
        // initialise instance variables
        this.setTemperature(defaultTemparature);
    }
    
    /**
     * Constructor for a new Element object with an initial temperature.
     * @param temperature the initial temperature
     */
    private Temperature(final double temperature){
        this.setTemperature(temperature);
    }
    
    /**
     * Creates a new Temperature Object from Celsius
     * @param celsius The Temperature in Celsius
     * @return A new Temperature Object.
     */
    public static Temperature createFromCelsius(final double celsius){
        return new Temperature(celsius);
    }
    
    /**
     * Creates a new Temperature Object from Kelvin
     * @param kelvin The Temperature in Kelvin
     * @return A new Temperature Object.
     */
    public static Temperature createFromKelvin(final double kelvin){
        return new Temperature(kelvin - KELVIN_OFFSET);
    }
    
    /**
     * Converts the given temperature to Kelvin.
     * @param celsiusTemperature The temperature to convert.
     * @return The converted temperature in Kelvin.
     */
    public static double convertCelsiusToKelvin(final double celsiusTemperature) throws TemperatureException
    {
        double minTemperature = KELVIN_OFFSET * -1;
        if(celsiusTemperature < minTemperature){
            throw new TemperatureException("Value cannot be less than " + minTemperature);
        }
        
        return celsiusTemperature + KELVIN_OFFSET;
    }

    /**
     * Gets the current temperature in the given type.
     * @param type The temperature type to return the value in.
     * @return The current temperature in the selected type.
     */
    public double getTemparature(TemperatureType type) throws TemperatureException
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
        double minTemperature = KELVIN_OFFSET * -1;
        if(newTempCelsius < minTemperature){
            throw new IllegalArgumentException("New Temp cannot be less than " + minTemperature);
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
