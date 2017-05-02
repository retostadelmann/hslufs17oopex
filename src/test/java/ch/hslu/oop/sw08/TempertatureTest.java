/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import ch.hslu.oop.sw06.Element;
import ch.hslu.oop.sw10.TemperatureException;
import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

/**
 *
 * @author reto.stadelmann
 */
public class TempertatureTest {
    
    double delta = 0.0002d;

    @Test
    public void getTemperatureCelsius() throws TemperatureException{
        assertEquals(23, Temperature.createFromCelsius(23).getTemparature(TemperatureType.Celsius), delta);
    }
    
    @Test
    public void getTemperatureKelvin() throws TemperatureException{
        assertEquals(296.15, Temperature.createFromCelsius(23).getTemparature(TemperatureType.Kelvin), delta);
    }
    
    @Test
    public void getTemperatureFarenheit() throws TemperatureException{
        assertEquals(
                73.4, 
                Temperature.createFromCelsius(23).getTemparature(
                        TemperatureType.Farenheit
                ),
                0.0002f);
    }
    
    @Test
    public void conversionCelsiusToKelvin() throws TemperatureException{
        assertEquals(263.15, Temperature.convertCelsiusToKelvin(-10), delta);
    }
    
    @Test(expected = TemperatureException.class)
    public void conversionCelsiusToKelvinWithUnsupportedValue() throws TemperatureException
    {
        Temperature.convertCelsiusToKelvin(-300);          
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setTemperatureWithUnsupportedValue()
    {
        Temperature.createFromCelsius(0).setTemperature(-300);          
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setTemperaturWithinvalidKelvinValue()
    {
        Temperature.createFromKelvin(-1);          
    }
    
    @Test
    public void setTemperatureWithSupportedValue(){
        try {
            Temperature tempTest = Temperature.createFromCelsius(25);
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
        assertTrue(Temperature.createFromCelsius(25).equals(Temperature.createFromCelsius(25)));
    }
    
    @Test
    public void equalsNegative(){
        assertFalse(Temperature.createFromCelsius(25).equals(Temperature.createFromCelsius(26)));
    }
    
    @Test
    public void compareToLower(){
        assertEquals(-1, Temperature.createFromCelsius(25).compareTo(Temperature.createFromCelsius(99.5)));
    }
    
    @Test
    public void compareToEqual(){
        assertEquals(0, Temperature.createFromCelsius(25).compareTo(Temperature.createFromCelsius(25)));
    }
    
    @Test
    public void compareToHigher(){
        assertEquals(1, Temperature.createFromCelsius(105).compareTo(Temperature.createFromCelsius(99.5)));
    }
    
    @Test
    public void isImmutable(){
         //assertImmutable(Element.class);
    }
}
