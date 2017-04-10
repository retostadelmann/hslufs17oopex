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
    public void add(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        
        // If the test gets here, it did not throw an error
        assertTrue(true);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void addNullTemp(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(null);
    }
    
    @Test
    public void countEquals(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        history.add(new Temperature(35));
        assertEquals(2, history.getCount());
    }
    
    @Test
    public void clear(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        history.add(new Temperature(35));
        
        history.clear();
        
        assertEquals(0, history.getCount());
    }
    
    @Test
    public void getMax(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        Temperature highest = new Temperature(35);
        history.add(highest);
        history.add(new Temperature(-30));
        
        assertEquals(highest, history.getMaxValue());
    }
    
    @Test
    public void getMin(){
        TemperatureHistory history = new TemperatureHistory();
        history.add(new Temperature(25));
        Temperature lowest = new Temperature(-40);
        history.add(lowest);
        history.add(new Temperature(-30));
        
        assertEquals(lowest, history.getMinValue());
    }
}
