/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import ch.hslu.demo.Helpers;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.OptionalDouble;

/**
 *
 * @author reto.stadelmann
 */
public final class TemperatureHistory {

    private final Collection<Temperature> temperatures;

    /**
     * Instantiates a new temperature history object.
     */
    public TemperatureHistory() {
        this.temperatures = new ArrayList<>();
    }

    /**
     * Adds a new temperature to the temperature history.
     *
     * @param temp The temperature to add.
     */
    public void add(Temperature temp) {
        Helpers.checkNullArgument(temp, "temp");

        this.temperatures.add(temp);
    }

    /**
     * Clears the current history entries.
     */
    public void clear() {
        this.temperatures.clear();
    }

    /**
     * Returns the amount of stored temperatures in this objects history.
     *
     * @return The amount of temperature entries.
     */
    public int getCount() {
        return this.temperatures.size();
    }

    /**
     * Returns the highest value in the history.
     *
     * @return The temperature with the highest value.
     * @throws UnsupportedOperationException
     */
    public Temperature getMaxValue() {
        checkForNoHistoryEntries();
        return Collections.max(this.temperatures);
    }

    /**
     * Returns the lowest value in the history.
     *
     * @return The temperature with the lowest value.
     * @throws UnsupportedOperationException
     */
    public Temperature getMinValue() {
        checkForNoHistoryEntries();
        return Collections.min(this.temperatures);
    }

    /**
     * Returns the average of all entries in the history
     *
     * @return The average temperature value.
     * @throws UnsupportedOperationException
     */
    public double getAverageValue() {
        checkForNoHistoryEntries();
        
        OptionalDouble average
                = this.temperatures
                        .stream()
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
}