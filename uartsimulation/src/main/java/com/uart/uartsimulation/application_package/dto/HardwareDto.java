package com.uart.uartsimulation.application_package.dto;

import com.uart.uartsimulation.application_package.entity.SensorData;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareDto {

    @NotBlank
    @Size(min = 3, max = 5, message = "Device name must be 5 characters and no less than 3 characters")
    private String deviceName;

    @NotNull
    private SensorData sensorData;
}