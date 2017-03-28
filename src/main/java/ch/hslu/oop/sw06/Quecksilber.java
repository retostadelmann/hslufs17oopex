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
public class Quecksilber extends Element {

    public Quecksilber() {
        super();
        this.ElementName = this.getElementName();
    }

    public Quecksilber(final double temperature) {
        super(temperature);
        this.ElementName = this.getElementName();
    }

    @Override
    public String getElementState(String element) {
        String zustand;

        if (this.tempCels < 327.43) {
            zustand = "Fest";
        } else if (this.tempCels < 1744) {
            zustand = "Flüssig";
        } else {
            zustand = "Gasförmig";
        }

        return zustand;
    }

    @Override
    public String getElementName() {
        return "Quecksilber";
    }
}
