/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author reto.stadelmann
 */
public interface SwitchStateListener extends PropertyChangeListener {
    
    /**
     * Override as hell.
     * @param pce
     */
    @Override
   public void propertyChange(PropertyChangeEvent pce);
    
}
