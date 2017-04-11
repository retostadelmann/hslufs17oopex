/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.chslu.oop.sw08;

import ch.hslu.oop.sw08.Temperature;
import ch.hslu.oop.sw08.TemperatureHistory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class TemperatureHistoryTest {
    
    @Test
    public void tetsAddNewTemperature(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        
        // If the test gets here, it did not throw an error
        assertTrue(true);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAddNullTemp(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(null);
    }
    
    @Test
    public void testCountEquals(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        history.add(new Temperature(35));
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
    public void testClearHistory(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        history.add(new Temperature(35));
        
        history.clear();
        
        assertEquals(0, history.getCount());
    }
    
    @Test
    public void testGetMax(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        Temperature highest = new Temperature(35);
        history.add(highest);
        history.add(new Temperature(-30));
        
        assertEquals(highest, history.getMaxValue());
    }
    
    @Test
    public void testGetMin(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        Temperature lowest = new Temperature(-40);
        history.add(lowest);
        history.add(new Temperature(-30));
        
        assertEquals(lowest, history.getMinValue());
    }
    
    @Test
    public void testGetAverage(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(10));
        history.add(new Temperature(20));
        history.add(new Temperature(30));
        
        assertEquals(20, history.getAverageValue(), 0.0002d);
    }
}
