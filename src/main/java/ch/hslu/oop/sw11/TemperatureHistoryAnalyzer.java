/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import ch.hslu.demo.App;
import ch.hslu.oop.sw08.Temperature;
import ch.hslu.oop.sw08.TemperatureEventListener;
import ch.hslu.oop.sw08.TemperatureHistory;
import ch.hslu.oop.sw08.TemperatureHistoryMaxEvent;
import ch.hslu.oop.sw08.TemperatureHistoryMinEvent;
import ch.hslu.oop.sw08.TemperatureType;
import ch.hslu.oop.sw10.TemperatureException;
import java.util.Scanner;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public final class TemperatureHistoryAnalyzer implements TemperatureEventListener {
        private Logger LOG = LogManager.getLogger(TemperatureHistoryAnalyzer.class);

    public TemperatureHistoryAnalyzer() throws TemperatureException{
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.addTemperatureEventListener(this);
        String input;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        do {         
            System.out.println("\r\nBitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if(!input.equals("exit")){
                try{
                    float value = Float.valueOf(input);
                    Temperature t = Temperature.createFromCelsius(value);
                    System.out.println("Temperatur ist " + t.getTemparature(TemperatureType.Celsius) + " Grad Celsius.");
                    
                    temperatureHistory.add(t);
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
        LOG.info("Anzal aufgezeichnete Punkte: " + temperatureHistory.getCount());
        if(temperatureHistory.getCount() > 0) {
            LOG.info("Durchschnittstemperatur: " + temperatureHistory.getAverageValue());
            LOG.info("Tiefste Temperatur: " + temperatureHistory.getMinValue().getTemparature(TemperatureType.Celsius));
            LOG.info("Höchste Temperatur: " + temperatureHistory.getMaxValue().getTemparature(TemperatureType.Celsius));
        }
    }

    @Override
    public void HandleTemperatureMinEvent(TemperatureHistoryMinEvent e){
            try {
                LOG.info("New lowest temperature: " + ((Temperature)e.getSource()).getTemparature(TemperatureType.Celsius));
            } catch (TemperatureException ex) {
                java.util.logging.Logger.getLogger(TemperatureHistoryAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void HandleTemperatureMaxEvent(TemperatureHistoryMaxEvent e) {
            try {
                LOG.info("New highest temperature: " + ((Temperature)e.getSource()).getTemparature(TemperatureType.Celsius));
            } catch (TemperatureException ex) {
                java.util.logging.Logger.getLogger(TemperatureHistoryAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
