/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Test class for {@link ch.hslu.oop.sw06.ICalculator}-Klasse
 * @author reto.stadelmann
 */
public class CalculatorTest {
    ICalculator testCalculator;
    
    @Before
    public void createInstance(){
        this.testCalculator = new Calculator();
    }
    
    /*
    * Test for the addition method with two zero values.
    */
    @Test 
    public void testAdditonWithZeroValues(){
            assertEquals(0, this.testCalculator.addition(0,0));
    }
    
    /*
    * Test for the addition method with one positive values.
    */
    @Test 
    public void testAdditonWithOnePositiveValue(){
            assertEquals(8, this.testCalculator.addition(0,8));
    }
            
    /*
    * Test for the addition method with two positive values.
    */
    @Test 
    public void testAdditonWithTwoPositiveValues(){
            assertEquals(15, this.testCalculator.addition(7,8));
    }
    
    /*
    * Test for the addition method with one negative value
    */
    @Test 
    public void testAdditonWithOneNegativeValue(){
            assertEquals(-10, this.testCalculator.addition(10,-20));
    }
    
    /*
    * Test for the addition method with two negative values.
    */
    @Test 
    public void testAdditonWithTwoNegativeValues(){
            assertEquals(-20, this.testCalculator.addition(-13,-7));
    }
    
     /*
    * Test for the addition method with two values
    * when one of them is a casted negataive float value and the other
    * is a positive value.
    */
    @Test 
    public void testAdditonWithCastedNegativeFloatValue(){
            assertEquals(-6, this.testCalculator.addition((int)-13.9,7));          
    }
}
