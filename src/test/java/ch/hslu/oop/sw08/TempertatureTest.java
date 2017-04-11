/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class TempertatureTest {
    
    double delta = 0.0002d;

    @Test
    public void getTemperatureCelsius(){
        assertEquals(23, new Temperature(23).getTemparature(TemperatureType.Celsius), delta);
    }
    
    @Test
    public void getTemperatureKelvin(){
        assertEquals(296.15, new Temperature(23).getTemparature(TemperatureType.Kelvin), delta);
    }
    
    @Test
    public void getTemperatureFarenheit(){
        assertEquals(
                73.4, 
                new Temperature(23).getTemparature(
                        TemperatureType.Farenheit
                ),
                0.0002f);
    }
    
    @Test
    public void conversionCelsiusToKelvin(){
        assertEquals(263.15, Temperature.convertCelsiusToKelvin(-10), delta);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void conversionCelsiusToKelvinWithUnsupportedValue()
    {
        Temperature.convertCelsiusToKelvin(-300);          
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setTemperatureWithUnsupportedValue()
    {
        new Temperature().setTemperature(-300);          
    }
    
    @Test
    public void setTemperatureWithSupportedValue(){
        try {
            Temperature tempTest = new Temperature(25);
            tempTest.setTemperature(20);
            assertTrue(true);
        } catch (IllegalArgumentException e) {
          assertTrue(false);
        }
    }
    
    @Test
    public void verifyEquals() {
        EqualsVerifier
                .forClass(Temperature.class)
                .withOnlyTheseFields("tempCels")
                .verify();
    }
    
    @Test
    public void equalsPositive(){
        assertTrue(new Temperature(25).equals(new Temperature(25)));
    }
    
    @Test
    public void equalsNegative(){
        assertFalse(new Temperature(25).equals(new Temperature(26)));
    }
    
    @Test
    public void compareToLower(){
        assertEquals(-1, new Temperature(25).compareTo(new Temperature(99.5)));
    }
    
    @Test
    public void compareToEqual(){
        assertEquals(0, new Temperature(25).compareTo(new Temperature(25)));
    }
    
    @Test
    public void compareToHigher(){
        assertEquals(1, new Temperature(105).compareTo(new Temperature(99.5)));
    }
}
