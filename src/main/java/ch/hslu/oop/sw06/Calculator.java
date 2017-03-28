/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

/**
 * Uses {@link ch.hslu.oop.sw06.ICalculator}
 * @author reto.stadelmann
 */
public class Calculator implements ICalculator{

    @Override
    public int addition(final int x, final int y) {
        return x + y;
    }

}
