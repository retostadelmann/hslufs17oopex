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
public class Motor extends SwitchableMotorPart {
    private int rotations = 0;   
    private int switchCount;
    
    public void changeRotation(int amount){
        this.rotations += amount;
        this.fireSwitchStateChangedEvent(new PropertyChangeEvent(this, "rotations", null, null));
    }
    
    private void setRotations(int number){
        this.rotations = number;
    }
    
    public int getRotation(){
        return this.rotations;
    }
    
    @Override
    public void switchOn() {
        if(!this.isSwitchedOn()){
            this.setRotations(1000);
            this.switchCount++;
            if(this.switchCount > 3){
                this.switchState = SwitchState.ERROR;
                this.fireSwitchStateChangedEvent(new PropertyChangeEvent(this, "SwitchState", SwitchState.OFF, SwitchState.ERROR));
                this.switchCount = 0;
            }
            else{
                this.switchState = SwitchState.ON;
                this.fireSwitchStateChangedEvent(new PropertyChangeEvent(this, "SwitchState", SwitchState.OFF, SwitchState.ON));
            }
        }
    }

    @Override
    public void switchOff() {
        if(!this.isSwitchedOff()){
            this.switchState = SwitchState.OFF;
            this.setRotations(0);
            this.fireSwitchStateChangedEvent(new PropertyChangeEvent(this, "SwitchStates", SwitchState.ON, SwitchState.OFF));
        }
    }
}