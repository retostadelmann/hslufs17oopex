/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

import ch.hslu.oop.sw08.Temperature;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author reto.stadelmann
 */
@Immutable
public final class Blei extends Element{    
    public Blei(){
        super();
        this.elementName = this.getElementName();
    }
    
    public Blei(final double temperature){
        super(temperature);
        this.elementName = this.getElementName();
    }

    @Override
    public AggregateState getElementState() {      
        if(this.temperature.getTemparature(Temperature.TemperatureType.Celsius) < -38.83){
            return AggregateState.Solid;
        }
        else if (this.temperature.getTemparature(Temperature.TemperatureType.Celsius) < 357){
            return AggregateState.Liquid;
        }
        else{
            return AggregateState.Gas;
        }
    }  

    @Override
    public String getElementName() {
        return "Blei";
    }
    
    @Override
    public String toString(){
        return super.toString() + " - GIFTIG";
    }
}
