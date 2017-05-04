package ch.hslu.oop.sw11;


import ch.hslu.oop.sw11.Motor;
import ch.hslu.oop.sw11.SwitchStateListener;
import java.beans.PropertyChangeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reto.stadelmann
 */
public class Car {
    private final Logger logger = LogManager.getLogger(Car.class);
    private final Motor motor;
    private final Light lightLeft;
    private final Light lightRight;
    
    public Car(){
        this.motor = new Motor();
        this.lightLeft = new Light();
        this.lightRight = new Light();
        
        this.motor.addSwitchStateListener(e -> this.handleMotorEvent("Event vom Motor", e));    
        this.lightLeft.addSwitchStateListener(e -> this.handleLightEvent("Event von Licht Links",  e));
        this.lightRight.addSwitchStateListener(e -> this.handleLightEvent("Event von Licht Rechts",  e));
    }
    
    public void turnOn(){
        this.motor.switchOn();
        this.lightLeft.switchOn();
        this.lightRight.switchOn();
    }
    
    public void turnOff(){
        this.motor.switchOff();
        this.lightLeft.switchOff();
        this.lightRight.switchOff();
    }

    public void handleMotorEvent(final String message, final PropertyChangeEvent e) {
       logger.info(message + ": Property " + e.getPropertyName() + " has changed to " + e.getNewValue());
    }
    
    public void handleLightEvent(final String message, final PropertyChangeEvent e){
        logger.info(message + ": Property " + e.getPropertyName() + " has changed to " + e.getNewValue());
    }
}
