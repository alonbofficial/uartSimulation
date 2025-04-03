package com.uart.uartsimulation.application_package.service;

import com.uart.uartsimulation.application_package.dto.HardwareDto;

import java.util.List;

public interface IHardwareService {

    List<HardwareDto> getAllDevices();
    HardwareDto saveNewRecord(HardwareDto hardwareDto);
}
