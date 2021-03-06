/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13;

import ch.hslu.oop.sw11.SwitchStateListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author reto.stadelmann
 */
public class MotorView implements IMotorView{
        private Button btnOn;
        private Button btnOff;
        private Button btnRotationUp;
        private Button btnRotationDown;
        private BorderPane borderPane;
        private Label label;
    
    public MotorView(){
        this.label = new Label("The switch is OFF.");
        label.setStyle("-fx-background-color: red;");

        this.btnOn = new Button("On");       
        this.btnOff = new Button("Off");
        this.btnOff.setDisable(true);
        
        this.btnRotationUp = new Button("Rotation Up");
        this.btnRotationDown = new Button ("Rotation Down");
        this.btnRotationDown.setDisable(true);
        this.btnRotationUp.setDisable(true);
        
        this.borderPane = new BorderPane();  
        this.borderPane.setTop(btnOn);
        this.borderPane.setCenter(label);
        this.borderPane.setBottom(btnOff);
        this.borderPane.setLeft(btnRotationUp);
        this.borderPane.setRight(btnRotationDown);

    }

    @Override
    public Parent getContent() {
        return this.borderPane;
    }

    @Override
    public Button getOnButton() {
        return this.btnOn;
    }

    @Override
    public Button getOffButton() {
        return this.btnOff;
    }

    @Override
    public void setNewLabel(String text, String style) {
        label.setText(text);
        label.setStyle(style);
    }

    @Override
    public Button getRotationDownButton() {
        return this.btnRotationDown;
    }

    @Override
    public Button getRotationUpButton() {
        return this.btnRotationUp;
    }
    
    
}
