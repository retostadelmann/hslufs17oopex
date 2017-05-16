/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw14;

import ch.hslu.oop.sw11.Motor;
import ch.hslu.oop.sw11.SwitchStateListener;
import java.beans.PropertyChangeListener;
import java.util.EventListener;
import javafx.scene.Parent;
import javafx.scene.control.Button;
/**
 *
 * @author reto.stadelmann
 */
public interface IMotorView {
    Parent getContent();
    Button getOnButton();
    Button getOffButton();
    Button getRotationDownButton();
    Button getRotationUpButton();
    void setNewLabel(String text, String style);
}
