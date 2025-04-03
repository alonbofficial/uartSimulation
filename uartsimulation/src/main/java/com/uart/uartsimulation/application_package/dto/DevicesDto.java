package com.uart.uartsimulation.application_package.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record DevicesDto(
        List<HardwareDto> devices
) {}
