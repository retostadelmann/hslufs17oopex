/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12;

import ch.hslu.oop.sw08.Temperature;
import java.time.LocalDateTime;

/**
 *
 * @author reto.stadelmann
 */
public final class TemperatureMeasurementPoint {
    private Temperature temperature;
    private LocalDateTime timestamp;
    
    public TemperatureMeasurementPoint(final Temperature temperature, final LocalDateTime timestamp){
        if(temperature == null){
            throw new IllegalArgumentException("temperature");
        }
        if(timestamp == null){
            throw new IllegalArgumentException("timestamp");
        }
        
        this.temperature = temperature;
        this.timestamp = timestamp;
    }
    
    public Temperature getTemperature(){
        return this.temperature;
    }
    
    public LocalDateTime getTimestamp(){
        return this.timestamp;
    }
}
