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
public abstract class Shape {
    
    private int x, y;
    
    public Shape(final int x, final int y){
        this.x = x;
        this.y = y;     
    }
    
    public void Move(final int newX, final int newY){
        this.x = newX;
        this.y = newY;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public abstract int getPerimeter();
    
    public abstract int getArea();
    
}
