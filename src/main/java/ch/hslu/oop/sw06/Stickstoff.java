/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

/**
 *
 * @author reto.stadelmann
 */
public final class Stickstoff extends Element {

    public Stickstoff(){
        super();
        this.elementName = this.getElementName();
        this.setElementStateSwitchingPoints();
    }
    
    public Stickstoff(final double temperature){
        super(temperature);
        this.elementName = this.getElementName();
        this.setElementStateSwitchingPoints();
    }
    
    @Override
    protected final void setElementStateSwitchingPoints(){
        this.stateSwitchPoints.put(AggregateState.Solid, -201.1);
        this.stateSwitchPoints.put(AggregateState.Liquid, -196d);
    }

    @Override
    public final String getElementName() {
        return "Stickstoff";
    }
}
