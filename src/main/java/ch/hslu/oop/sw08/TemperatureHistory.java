/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import ch.hslu.demo.Helpers;
import ch.hslu.oop.sw10.*;
import ch.hslu.oop.sw12.*;
import java.time.LocalDateTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 *
 * @author reto.stadelmann
 */
public final class TemperatureHistory {

    private final List<TemperatureMeasurementPoint> temperatureMeasurementPoints;
    private final List<TemperatureEventListener> temperatureEventListeners;

    /**
     * Instantiates a new temperature history object.
     */
    public TemperatureHistory() {
        this.temperatureMeasurementPoints = new ArrayList<>();
        this.temperatureEventListeners = new ArrayList<>();
    }
    
    /**
     * Adds a new temperature to the temperature history.
     *
     * @param temp The temperature to add.
     * @throws ch.hslu.oop.sw10.TemperatureException
     */
    public void add(Temperature temp) throws TemperatureException {
        Helpers.checkNullArgument(temp, "temp");
  
        this.add(temp, LocalDateTime.now());       
    }

    /**
     * Adds a new temperature to the temperature history.
     *
     * @param temp The temperature to add.
     * @param timestamp The timestamp.
     * @throws ch.hslu.oop.sw10.TemperatureException
     */
    public void add(Temperature temp, LocalDateTime timestamp) throws TemperatureException {
        Helpers.checkNullArgument(temp, "temp");
        Helpers.checkNullArgument(timestamp, "timestamp");
                
        if (this.getCount() == 0 || temp.getTemparature(TemperatureType.Kelvin) < this.getLowestTemperatureValue().getTemparature(TemperatureType.Kelvin))
        {
            this.fireMinTemperatureEvent(new TemperatureHistoryMinEvent(temp));
        }
        
        if (this.getCount() == 0 || temp.getTemparature(TemperatureType.Kelvin) > this.getHighestTemperatureValue().getTemparature(TemperatureType.Kelvin))
        {
            this.fireMaxTemperatureEvent(new TemperatureHistoryMaxEvent(temp));
        }
        
        this.temperatureMeasurementPoints.add(new TemperatureMeasurementPoint(temp, timestamp));       
    }

    /**
     * Clears the current history entries.
     */
    public void clear() {
        this.temperatureMeasurementPoints.clear();
    }

    /**
     * Returns the amount of stored temperatureMeasurementPoints in this objects history.
     *
     * @return The amount of temperature entries.
     */
    public int getCount() {
        return this.temperatureMeasurementPoints.size();
    }
    
    public List<TemperatureMeasurementPoint> getTemperatures(){
        return this.temperatureMeasurementPoints;
    }

    /**
     * Returns the highest value in the history.
     *
     * @return The temperature with the highest value.
     * @throws UnsupportedOperationException
     */
    public Temperature getHighestTemperatureValue() {
        checkForNoHistoryEntries();
        return Collections.max(
                this.temperatureMeasurementPoints
                        .stream()
                        .map(i -> i.getTemperature())
                        .collect(Collectors.toList()));
    }

    /**
     * Returns the lowest value in the history.
     *
     * @return The temperature with the lowest value.
     * @throws UnsupportedOperationException
     */
    public Temperature getLowestTemperatureValue() {
        checkForNoHistoryEntries();
        return Collections.min(
                this.temperatureMeasurementPoints
                        .stream()
                        .map(i -> i.getTemperature())
                        .collect(Collectors.toList()));
    }
    
    /**
     * Returns the highest value in the history.
     *
     * @return The timestamp with the highest value.
     * @throws UnsupportedOperationException
     */
    public LocalDateTime getHighestTimestampValue(){
        checkForNoHistoryEntries();     
        return Collections.max(
                this.temperatureMeasurementPoints
                    .stream()
                    .map(i -> i.getTimestamp())
                    .collect(Collectors.toList()));           
    }
    
    /**
     * Returns the lowest value in the history.
     *
     * @return The timestamp with the lowest value.
     * @throws UnsupportedOperationException
     */
    public LocalDateTime getLowestTimestampValue(){
        checkForNoHistoryEntries();     
        return Collections.min(
                this.temperatureMeasurementPoints
                    .stream()
                    .map(i -> i.getTimestamp())
                    .collect(Collectors.toList()));           
    }

    /**
     * Returns the average of all entries in the history
     *
     * @return The average temperature value.
     * @throws UnsupportedOperationException
     */
    public double getAverageTemperatureValue() {
        checkForNoHistoryEntries();
        
        OptionalDouble average
                = this.temperatureMeasurementPoints
                        .stream().map(t -> t.getTemperature())
                        .mapToDouble(temp -> temp.tempCels)
                        .average();

        return average.isPresent() ? average.getAsDouble() : 0;
    }

    /**
     * Checks if the history contains any entries
     * and throws an exception if not.
     * @throws UnsupportedOperationException
     */
    private void checkForNoHistoryEntries() {
        if (this.getCount() == 0) {
            throw new UnsupportedOperationException(
                    "There are no Temperatures stored in the history list.");
        }
    }
    
    public void addTemperatureEventListener(TemperatureEventListener tel){
        if(tel == null){
            throw new IllegalArgumentException("Listener cannot be null");
        }
        
        this.temperatureEventListeners.add(tel);
    }
    
    public void removeTemperatureEventListener(TemperatureEventListener tel){
        if(tel == null){
            throw new IllegalArgumentException("Listener cannot be null");
        }
        
        this.temperatureEventListeners.remove(tel);
    }
    
    private void fireMaxTemperatureEvent(TemperatureHistoryMaxEvent thme){
        this.temperatureEventListeners.forEach((tel) -> {
            tel.HandleTemperatureMaxEvent(thme);
        });
    }
    
    private void fireMinTemperatureEvent(TemperatureHistoryMinEvent thme){
        this.temperatureEventListeners.forEach((tel) -> {
            tel.HandleTemperatureMinEvent(thme);
        });
    }
}