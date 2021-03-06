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
public abstract class SwitchableMotorPart implements ISwitch{
    protected SwitchState switchState = SwitchState.OFF;
    protected final List<SwitchStateListener> switchListeners ;
    
    protected SwitchableMotorPart(){
        this.switchListeners = new ArrayList();
    }

    @Override
    public void switchOn() {
        if(!this.isSwitchedOn()){
            this.switchState = SwitchState.ON;
            this.fireSwitchStateChangedEvent(new PropertyChangeEvent(this, "SwitchState", SwitchState.OFF, SwitchState.ON));          
        }
    }

    @Override
    public void switchOff() {
        if(!this.isSwitchedOff()){
            this.switchState = SwitchState.OFF;
             this.fireSwitchStateChangedEvent(new PropertyChangeEvent(this, "SwitchStates", SwitchState.ON, SwitchState.OFF));
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
    public SwitchState getState(){
        return this.switchState;
    }
    
    @Override
    public void addSwitchStateListener(final SwitchStateListener listener) {
        if(listener == null){
            throw new IllegalArgumentException();
        }
        
        this.switchListeners.add(listener);
    }

    @Override
    public void removeSwitchStateListener(final SwitchStateListener listener) {
        if(listener == null){
            throw new IllegalArgumentException();
        }
        
        this.switchListeners.remove(listener);
    }

    @Override
    public void fireSwitchStateChangedEvent(final PropertyChangeEvent pce) {
        this.switchListeners.forEach((l) -> {
            l.propertyChange(pce);
        });
    }
}
