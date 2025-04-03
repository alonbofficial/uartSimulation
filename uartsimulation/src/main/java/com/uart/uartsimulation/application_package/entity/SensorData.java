package com.uart.uartsimulation.application_package.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class SensorData {
    @Column(name = "temperature")
    private double temperature;

    @Column(name = "humidity")
    private double humidity;
}
