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
public interface ICountableSwitch extends ISwitch {

    /**
     * Returns an a long value indicating how many times the object has been switched on.
     *
     * @return a long value indicating how many times the object has been switched on.
     */
    public long GetSwitchCount();
}
