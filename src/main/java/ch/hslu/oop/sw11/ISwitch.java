/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import java.beans.PropertyChangeEvent;

/**
 *
 * @author reto.stadelmann
 */
public interface ISwitch {
    /**
     * Turns the switch on.
     */
    void switchOn();

    /**
     * Turns the switch off.
     */
    void switchOff();

    /**
     * Returns an a boolean value indicating whether the object is switched on or not.
     * @return      a boolean value indicating whether the object is switched on or not.
     */
    boolean isSwitchedOn();

    /**
     * Returns an a boolean value indicating whether the object is switched on or not.
     * @return      a boolean value indicating whether the object is switched off or not.
     */
    boolean isSwitchedOff();
    
    SwitchState getState();
    
    void addSwitchStateListener(SwitchStateListener listener);
    
    void removeSwitchStateListener(SwitchStateListener listener);
    
    void fireSwitchStateChangedEvent(PropertyChangeEvent pce);
}
