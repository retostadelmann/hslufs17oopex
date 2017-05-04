/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

/**
 *
 * @author reto.stadelmann
 */
public interface TemperatureEventListener {
    public void HandleTemperatureMinEvent(TemperatureHistoryMinEvent e);
    public void HandleTemperatureMaxEvent(TemperatureHistoryMaxEvent e);
}
