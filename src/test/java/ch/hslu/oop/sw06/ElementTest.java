/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

import static org.junit.Assert.*;
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
        assertEquals(23, new Blei(23).getTemparature(Element.TemperatureType.Celsius), 0.0002f);
    }
    
    /*
    * Testcase for the value in get temperature.
    */
    @Test
    public void testGetTemperatureKelvin(){
        assertEquals(296.15, new Blei(23).getTemparature(Element.TemperatureType.Kelvin), 0.02f);
    }
    
    /*
    * Testcase for the value in get temperature.
    */
    @Test
    public void testGetTemperatureFarenheit(){
        assertEquals(73.4, new Blei(23).getTemparature(Element.TemperatureType.Farenheit), 0.0002f);
    }
    
    /*
    * Testcase for an unsupported value in set temperature.
    */
    @Test
    public void testSetTemperatureWithUnsupportedValue(){
        boolean thrown = false;

        try {
            new Blei().setTemperature(-300);
        } catch (IllegalArgumentException e) {
          thrown = true;
        }

        assertTrue(thrown);       
    }
    
    /*
    * Testcase for a supported value in set temperature.
    */
    @Test
    public void testSetTemperatureWithSupportedValue(){
        boolean thrown = false;

        try {
            Blei bleiTest = new Blei(25);
            bleiTest.setTemperature(20);
        } catch (IllegalArgumentException e) {
          thrown = true;
        }

        assertFalse(thrown);       
    }
}
