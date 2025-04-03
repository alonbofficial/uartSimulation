package com.uart.uartsimulation.application_package.service;

import com.uart.uartsimulation.application_package.entity.SensorData;

public interface IRandomNameAndTemp {

    SensorData generateTemperatureAndHumidity(double minTemp, double maxTemp, double minHum, double maxHum);
    String generateDeviceName();
}
