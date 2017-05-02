
/*
 * Copyright 2016 Roland Gisler
 * Hochschule Luzern Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ch.hslu.oop.sw06.*;
import ch.hslu.oop.sw07.*;
import ch.hslu.oop.sw08.Temperature;
import ch.hslu.oop.sw08.TemperatureType;
import ch.hslu.oop.sw10.TemperatureException;
import java.util.Scanner;

/**
 * Demo-Applikation für {@link ch.hslu.demo.App}-Klasse.
 */
public final class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    /**
     * Privater Konstruktor.
     */
    private App() {
    }

    /**
     * Main-Method.
     * @param args Arguments.
     */
    public static void main(final String[] args) throws TemperatureException {
        Logger LOG = LogManager.getLogger(App.class);
        String input;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do {         
            LOG.info("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if(!input.equals("exit")){
                try{
                    float value = Float.valueOf(input);
                    Temperature t = Temperature.createFromCelsius(value);
                    LOG.info("Value is " + t.getTemparature(TemperatureType.Celsius));
                }
                catch(NumberFormatException ex){
                    LOG.error("No valid Number", ex);
                }
                catch(IllegalArgumentException ex){
                    LOG.error("Illegal Temperature", ex);
                }
            }
            else{
                exit = true;
            }
            
        } while (!exit);
        LOG.info("Programm beendet.");
    }
}
