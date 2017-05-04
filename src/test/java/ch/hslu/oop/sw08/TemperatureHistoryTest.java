/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import ch.hslu.oop.sw08.Temperature;
import ch.hslu.oop.sw08.TemperatureHistory;
import ch.hslu.oop.sw10.TemperatureException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class TemperatureHistoryTest {
    
    @Test
    public void tetsAddNewTemperature() throws TemperatureException{
        TemperatureHistory history = new TemperatureHistory();
        history.add(Temperature.createFromCelsius(25));
        
        // If the test gets here, it did not throw an error
        assertTrue(true);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAddNullTemp() throws TemperatureException{
        TemperatureHistory history = new TemperatureHistory();
        history.add(null);
    }
    
    @Test
    public void testCountEquals() throws TemperatureException{
        TemperatureHistory history = new TemperatureHistory();
        history.add(Temperature.createFromCelsius(25));
        history.add(Temperature.createFromCelsius(35));
        assertEquals(2, history.getCount());
    }
    
    @Test (expected = UnsupportedOperationException.class)
    public void testGetMaxValueException(){
        TemperatureHistory history = new TemperatureHistory();
        history.getMaxValue();
    }
    
    @Test (expected = UnsupportedOperationException.class)
    public void testGetMinValueException(){
        TemperatureHistory history = new TemperatureHistory();
        history.getMinValue();
    }
    
    @Test (expected = UnsupportedOperationException.class)
    public void testGetAverageValueException(){
        TemperatureHistory history = new TemperatureHistory();
        history.getAverageValue();
    }
    
    @Test
    public void testClearHistory() throws TemperatureException{
        TemperatureHistory history = new TemperatureHistory();
        history.add(Temperature.createFromCelsius(25));
        history.add(Temperature.createFromCelsius(35));
        
        history.clear();
        
        assertEquals(0, history.getCount());
    }
    
    @Test
    public void testGetMax() throws TemperatureException{
        TemperatureHistory history = new TemperatureHistory();
        history.add(Temperature.createFromCelsius(25));
        Temperature highest = Temperature.createFromCelsius(35);
        history.add(highest);
        history.add(Temperature.createFromCelsius(-30));
        
        assertEquals(highest, history.getMaxValue());
    }
    
    @Test
    public void testGetMin() throws TemperatureException{
        TemperatureHistory history = new TemperatureHistory();
        history.add(Temperature.createFromCelsius(25));
        Temperature lowest = Temperature.createFromCelsius(-40);
        history.add(lowest);
        history.add(Temperature.createFromCelsius(-30));
        
        assertEquals(lowest, history.getMinValue());
    }
    
    @Test
    public void testGetAverage() throws TemperatureException{
        TemperatureHistory history = new TemperatureHistory();
        history.add(Temperature.createFromCelsius(10));
        history.add(Temperature.createFromCelsius(20));
        history.add(Temperature.createFromCelsius(30));
        
        assertEquals(20, history.getAverageValue(), 0.0002d);
    }
}
