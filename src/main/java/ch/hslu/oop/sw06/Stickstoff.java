/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

import ch.hslu.oop.sw08.Temperature;

/**
 *
 * @author reto.stadelmann
 */
public final class Stickstoff extends Element {

    public Stickstoff(){
        super();
        this.elementName = this.getElementName();
    }
    
    public Stickstoff(final double temperature){
        super(temperature);
        this.elementName = this.getElementName();
    }

    @Override
    public AggregateState getElementState() {
        if(this.temperature.getTemparature(Temperature.TemperatureType.Celsius) < -210.1){
            return AggregateState.Solid;
        }
        else if (this.temperature.getTemparature(Temperature.TemperatureType.Celsius) < -196){
            return AggregateState.Liquid;
        }
        else{
            return AggregateState.Gas;
        }
    }  

    @Override
    public final String getElementName() {
        return "Stickstoff";
    }
}
