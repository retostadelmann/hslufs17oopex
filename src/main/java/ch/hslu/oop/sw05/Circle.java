/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw05;

/**
 *
 * @author reto.stadelmann
 */
public class Circle extends Shape {
    
    private int diameter;
    
    public Circle(final int x, final int y, final int diameter){
        super(x, y);
        this.diameter = diameter;
    }

    @Override
    public int getPerimeter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the diameter
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * @param diameter the diameter to set
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
    
}
