/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

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
        this.setElementStateSwitchingPoints();
    }
    
    public Blei(final double temperature){
        super(temperature);
        this.elementName = this.getElementName();
        this.setElementStateSwitchingPoints();
    }
    
    @Override
    protected final void setElementStateSwitchingPoints(){
        this.stateSwitchPoints.put(AggregateState.Solid, 327.43);
        this.stateSwitchPoints.put(AggregateState.Liquid, 1744d);
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
