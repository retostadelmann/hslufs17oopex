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
public final class Quecksilber extends Element {

    public Quecksilber() {
        super();
        this.elementName = this.getElementName();
    }

    public Quecksilber(final double temperature) {
        super(temperature);
        this.elementName = this.getElementName();
    }
    
    @Override
    public AggregateState getElementState() {
        if (this.temperature.getTemparature(Temperature.TemperatureType.Celsius) < 327.43) {
            return AggregateState.Solid;
        } else if (this.temperature.getTemparature(Temperature.TemperatureType.Celsius) < 1744) {
            return AggregateState.Liquid;
        } else {
            return AggregateState.Gas;
        }
    }

    @Override
    public final String getElementName() {
        return "Quecksilber";
    }
}
