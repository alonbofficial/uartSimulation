package com.uart.uartsimulation.application_package.service;

import com.uart.uartsimulation.application_package.entity.SensorData;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomNameAndTemp implements IRandomNameAndTemp{

    public SensorData generateTemperatureAndHumidity(double minTemp, double maxTemp, double minHum, double maxHum) {

        double temperature, humidity;
        temperature = minTemp + (Math.random() * maxTemp);
        humidity = minHum + (Math.random() * maxHum);

        //randomNumber = Math.round(randomNumber * 10.0) / 10.0; // Round to 1 decimal place
        String formattedTemperature = String.format("%.1f", temperature);
        String formattedHumidity = String.format("%.1f", humidity);

        SensorData sensorData = new SensorData(temperature, humidity);

        System.out.println("Random Number temperature: " + formattedTemperature);
        System.out.println("Random Number humidity: " + formattedHumidity);

        return sensorData;
    }

    public String generateDeviceName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder deviceName = new StringBuilder();
        Random random = new Random();

        // Generate a 5-character device name
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            deviceName.append(characters.charAt(randomIndex));
        }

        return deviceName.toString();
    }
}
