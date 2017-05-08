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
import ch.hslu.oop.sw12.TemperatureMeasurementPoint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
    TemperatureHistory temperatureHistory = new TemperatureHistory();

    /**
     * Create a new Analyzer using a CSV file.
     * @param filePath The CSV File
     * @throws TemperatureException 
     */
    public TemperatureHistoryAnalyzer(String filePath) throws TemperatureException {
        if (new File(filePath).exists()) {
            try (final BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(
                            new FileInputStream(filePath), Charset.forName("UTF-8")))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] temperatureData = line.split(";");
                    String ID = temperatureData[0];
                    LocalDateTime timestamp
                            = LocalDateTime.parse(temperatureData[1],
                                    DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
                    Temperature temperature = Temperature.createFromCelsius(Double.valueOf(temperatureData[2]));
                    Double humidity = Double.valueOf(temperatureData[3]);

                    temperatureHistory.add(temperature, timestamp);
                }
            } catch (IOException exception) {
                LOG.error(exception.getMessage(), exception);
            }
        }

        LOG.info("Anzahl aufgezeichnete Punkte: " + temperatureHistory.getCount());
        LOG.info("Durchschnittstemperatur: " + temperatureHistory.getAverageTemperatureValue());
        LOG.info("Tiefste Temperatur: " + temperatureHistory.getLowestTemperatureValue().getTemparature(TemperatureType.Celsius));
        LOG.info("Höchste Temperatur: " + temperatureHistory.getHighestTemperatureValue().getTemparature(TemperatureType.Celsius));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LOG.info("Zeitspanne erfasst: " + temperatureHistory.getLowestTimestampValue().format(formatter) + " - " + temperatureHistory.getHighestTimestampValue().format(formatter));
    }

    /**
     * Create a new Analyzer using the user input.
     * @throws TemperatureException 
     */
    public TemperatureHistoryAnalyzer() throws TemperatureException {
        temperatureHistory.addTemperatureEventListener(this);
        String input;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println("\r\nBitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if (!input.equals("exit")) {
                try {
                    float value = Float.valueOf(input);
                    Temperature t = Temperature.createFromCelsius(value);
                    System.out.println("Temperatur ist " + t.getTemparature(TemperatureType.Celsius) + " Grad Celsius.");

                    temperatureHistory.add(t);
                } catch (NumberFormatException ex) {
                    LOG.error("No valid Number", ex);
                } catch (IllegalArgumentException ex) {
                    LOG.error("Illegal Temperature", ex);
                }
            } else {
                exit = true;
            }

        } while (!exit);

        LOG.info("Programm beendet.");
        LOG.info("Anzal aufgezeichnete Punkte: " + temperatureHistory.getCount());
        if (temperatureHistory.getCount() > 0) {
            LOG.info("Durchschnittstemperatur: " + temperatureHistory.getAverageTemperatureValue());
            LOG.info("Tiefste Temperatur: " + temperatureHistory.getLowestTemperatureValue().getTemparature(TemperatureType.Celsius));
            LOG.info("Höchste Temperatur: " + temperatureHistory.getHighestTemperatureValue().getTemparature(TemperatureType.Celsius));
        }
    }

    public int getCount() {
        return this.temperatureHistory.getCount();
    }

    public List<TemperatureMeasurementPoint> getTemperatures() {
        return this.temperatureHistory.getTemperatures();
    }

    @Override
    public void HandleTemperatureMinEvent(TemperatureHistoryMinEvent e) {
        try {
            LOG.info("New lowest temperature: " + ((Temperature) e.getSource()).getTemparature(TemperatureType.Celsius));
        } catch (TemperatureException ex) {
            java.util.logging.Logger.getLogger(TemperatureHistoryAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void HandleTemperatureMaxEvent(TemperatureHistoryMaxEvent e) {
        try {
            LOG.info("New highest temperature: " + ((Temperature) e.getSource()).getTemparature(TemperatureType.Celsius));
        } catch (TemperatureException ex) {
            java.util.logging.Logger.getLogger(TemperatureHistoryAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
