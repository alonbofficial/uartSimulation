package com.uart.uartsimulation.application_package.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id", nullable = false)
    private Long deviceId;

    @Column(name = "device_name", nullable = false)
    private String deviceName;

    @Embedded
    private SensorData sensorData;
}
