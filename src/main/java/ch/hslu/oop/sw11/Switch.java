/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reto.stadelmann
 */
public abstract class Switch implements ISwitch{
    private SwitchState switchState = SwitchState.OFF;
    private final List<SwitchStateListener> switchListeners ;
    
    public Switch(){
        this.switchListeners = new ArrayList();
    }

    @Override
    public void switchOn() {
        if(!this.isSwitchedOn()){
            this.switchState = SwitchState.ON;
            this.fireSwitchStateChangedEvent(new PropertyChangeEvent(this, this.switchState.name(), this, this));
        }
    }

    @Override
    public void switchOff() {
        if(this.isSwitchedOff()){
            this.switchState = SwitchState.OFF;
             this.fireSwitchStateChangedEvent(new PropertyChangeEvent(this, this.switchState.name(), this, this));
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.switchState == SwitchState.ON;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.switchState != SwitchState.ON;
    }

    @Override
    public void addSwitchStateListener(SwitchStateListener listener) {
        if(listener == null){
            throw new IllegalArgumentException();
        }
        
        this.switchListeners.add(listener);
    }

    @Override
    public void removeSwitchStateListener(SwitchStateListener listener) {
        if(listener == null){
            throw new IllegalArgumentException();
        }
        
        this.switchListeners.remove(listener);
    }

    @Override
    public void fireSwitchStateChangedEvent(PropertyChangeEvent pce) {
        for(SwitchStateListener l : this.switchListeners){
            l.propertyChange(pce);
        }
    }
}
