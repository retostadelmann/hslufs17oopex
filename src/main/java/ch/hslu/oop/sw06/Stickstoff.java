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
public class Stickstoff extends Element {

    public Stickstoff(){
        super();
        this.ElementName = this.getElementName();
    }
    
    public Stickstoff(final double temperature){
        super(temperature);
        this.ElementName = this.getElementName();
    }

    @Override
    public String getElementState(String element) {
        String zustand;
        
        if(this.tempCels < -210.1){
            zustand = "Fest";
        }
        else if (this.tempCels < -196){
            zustand = "Flüssig";
        }
        else{
            zustand = "Gasförmig";
        }
        
        return zustand;
    }  

    @Override
    public String getElementName() {
        return "Stickstoff";
    }
}
