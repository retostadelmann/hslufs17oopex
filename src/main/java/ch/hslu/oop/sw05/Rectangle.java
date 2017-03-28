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
public class Rectangle extends Shape {
    
    private int width, height;
    
    public Rectangle(final int x, final int y, final int width, final int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void ChangeDimension(final int newWidth, final int newHeight){
        this.width = newWidth;
        this.height = newHeight;
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
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
}
