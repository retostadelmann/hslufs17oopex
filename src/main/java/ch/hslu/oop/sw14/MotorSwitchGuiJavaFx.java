/*
 * Copyright 2016 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.oop.sw14;

import ch.hslu.oop.sw11.ISwitch;
import ch.hslu.oop.sw11.Motor;
import ch.hslu.oop.sw11.SwitchState;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Einfaches SwitchGUI mit Java FX implementiert.
 */
@SuppressWarnings("restriction")
public final class MotorSwitchGuiJavaFx extends Application {
    Motor motor = new Motor();
    IMotorView motorView = new MotorView();
    
    @Override
    public void start(final Stage primaryStage) {     

        primaryStage.setTitle("Switch GUI with JavaFX");
        
        motorView.getOnButton().setOnAction((final ActionEvent event) -> {
            motor.switchOn();
            if(motor.getState() != SwitchState.ERROR){
                motorView.setNewLabel("The switch is ON.", "-fx-background-color: green;");
                 
            }
            motorView.getOnButton().setDisable(true);
            motorView.getOffButton().setDisable(false);
            motorView.getRotationDownButton().setDisable(false);
            motorView.getRotationUpButton().setDisable(false);
        });
        
        motorView.getOffButton().setOnAction((final ActionEvent event) -> {
            turnOffMotor();
        });
        
        motorView.getRotationDownButton().setOnAction((final ActionEvent event) -> {
            motor.changeRotation(-1000);
        });
        motorView.getRotationUpButton().setOnAction((final ActionEvent event) -> {
            motor.changeRotation(1000);
        });
        
        motor.addSwitchStateListener(e -> this.handleMotorEvent(e));
    
        primaryStage.setScene(new Scene(motorView.getContent(), 400, 100));
        primaryStage.show();
    }

    /**
     * main-Methode startet die JavaFX-Application.
     * @param args nicht verwendet.
     */
    public static void main(final String[] args) {
        launch(MotorSwitchGuiJavaFx.class, args);
    }
    
    private void turnOffMotor(){
        motor.switchOff();
        motorView.setNewLabel("The switch is OFF.", "-fx-background-color: red;");
        motorView.getOnButton().setDisable(false);
        motorView.getOffButton().setDisable(true);
        motorView.getRotationDownButton().setDisable(true);
        motorView.getRotationUpButton().setDisable(true);
    }

    private void handleMotorEvent(final PropertyChangeEvent e) {
        if(SwitchState.ERROR == e.getNewValue()){
            this.motorView.setNewLabel("The switch has an error!", "-fx-background-color: yellow;");
        }
        if(((Motor)e.getSource()).getRotation() <= 0){
            turnOffMotor();
        }
        else if(((Motor)e.getSource()).getRotation() > 6000){
            this.motorView.setNewLabel("The switch has an error!", "-fx-background-color: yellow;");
        }
    }
}