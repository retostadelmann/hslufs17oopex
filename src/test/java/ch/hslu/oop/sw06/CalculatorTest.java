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
    float delta = 0.00002f;
    
    @Before
    public void createInstance(){
        this.testCalculator = new Calculator();
    }
    
    /*
    * Test for the addition method with two max values
    */
    @Test
    public void testWithIntMaxValues(){
        assertEquals(
                (long)Integer.MAX_VALUE*2,
                this.testCalculator.addition(
                        Integer.MAX_VALUE, 
                        Integer.MAX_VALUE
                ));
    }
    /*
    * Test for the addition method with two max values
    */
    @Test
    public void testWithIntMinValues(){
        assertEquals(
                (long)Integer.MIN_VALUE*2,
                this.testCalculator.addition(
                        Integer.MIN_VALUE, 
                        Integer.MIN_VALUE
                ));
    }
    
    /*
    * Test for the addition method with two zero values.
    */
    @Test 
    public void testAdditonWithZeroValues(){
            assertEquals(0f, this.testCalculator.addition(0,0), delta);
    }
    
    /*
    * Test for the addition method with one positive values.
    */
    @Test 
    public void testAdditonWithOnePositiveValue(){
            assertEquals(8f, this.testCalculator.addition(0,8), delta);
    }
            
    /*
    * Test for the addition method with two positive values.
    */
    @Test 
    public void testAdditonWithTwoPositiveValues(){
            assertEquals(15f, this.testCalculator.addition(7,8), delta);
    }
    
    /*
    * Test for the addition method with one negative value
    */
    @Test 
    public void testAdditonWithOneNegativeValue(){
            assertEquals(-10f, this.testCalculator.addition(10,-20), delta);
    }
    
    /*
    * Test for the addition method with two negative values.
    */
    @Test 
    public void testAdditonWithTwoNegativeValues(){
            assertEquals(-20f, this.testCalculator.addition(-13,-7), delta);
    }
    
     /*
    * Test for the addition method with two values
    * when one of them is a casted negataive float value and the other
    * is a positive value.
    */
    @Test 
    public void testAdditonWithCastedNegativeFloatValue(){
            assertEquals(-6, this.testCalculator.addition((int)-13.9,7), delta);          
    }
}
