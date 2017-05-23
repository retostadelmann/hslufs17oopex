/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class Worker {
    Logger logger = LogManager.getLogger(Worker.class);
    private final int a,b;
    
    public Worker(final int a, final int b){
        this.a = a;
        this.b = b;
    }
    
    public int addition() throws InterruptedException
    {
        Thread.sleep((long)(Math.random() * 1000));
        int result = a + b;
        logger.info("Result of Worker Addition is " + result);
        return result;
    }
}
