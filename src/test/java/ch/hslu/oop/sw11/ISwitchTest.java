/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class ISwitchTest {
    
    @Test
    public void isSwitchedOn(){
       ISwitch motor = new Motor();
       motor.switchOn();
       assertTrue(motor.isSwitchedOn());
    }
    
    @Test
    public void isSwitchedOff(){
       ISwitch motor = new Motor();
       motor.switchOff();
       assertTrue(motor.isSwitchedOff());
    }
}
