/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

import ch.hslu.oop.sw08.Temperature;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author reto.stadelmann
 */
public class ElementTest {

   
    /*
    * Testcase for the value in get temperature.
    */
    @Test
    public void testGetTemperatureCelsius(){
        assertEquals(
                23, 
                new Blei(23)
                        .getTemparature(Temperature.TemperatureType.Celsius), 
                0.0002f);
    }
    
    /*
    * Testcase for the value in get temperature.
    */
    @Test
    public void testGetTemperatureKelvin(){
        assertEquals(
                296.15, 
                new Blei(23)
                        .getTemparature(Temperature.TemperatureType.Kelvin),
                0.02f);
    }
    
    /*
    * Testcase for the value in get temperature.
    */
    @Test
    public void testGetTemperatureFarenheit(){
        assertEquals(
                73.4,
                new Blei(23)
                        .getTemparature(Temperature.TemperatureType.Farenheit),
                0.0002f);
    }
    
    /*
    * Testcase for an unsupported value in set temperature.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testSetTemperatureWithUnsupportedValue(){

            new Blei().setTemperature(-300);          
    }
    
    /*
    * Testcase for a supported value in set temperature.
    */
    @Test
    public void testSetTemperatureWithSupportedValue(){
        try {
            Blei bleiTest = new Blei(25);
            bleiTest.setTemperature(20);
            assertTrue(true);
        } catch (IllegalArgumentException e) {
          assertTrue(false);
        }
    }
    
    @Test
    public void verifyEquals() {
        EqualsVerifier
                .forClass(Blei.class)
                .withOnlyTheseFields("elementName")
                .verify();
    }
    
    @Test
    public void testEqualsPositive(){
        assertTrue(new Blei(25).equals(new Blei(26)));
    }
    
    @Test
    public void testEqualsNegative(){
        assertFalse(new Blei(25).equals(new Stickstoff(26)));
    }
}
