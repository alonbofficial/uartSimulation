package com.uart.uartsimulation.application_package.service;

import com.uart.uartsimulation.application_package.dto.HardwareDto;
import com.uart.uartsimulation.application_package.entity.SensorData;
import com.uart.uartsimulation.application_package.entity.Hardware;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.uart.uartsimulation.application_package.repo.HardwareRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HardwareService implements IHardwareService {

    private final HardwareRepo hardwareRepo;
    private final ModelMapper modelMapper;
    private final IRandomNameAndTemp randomNameAndTemp;
    private final SimpMessagingTemplate template;
    private boolean generateName = true;
    private String name = "";

    private double TEMP_MIN_VALUE = 10;
    private double TEMP_MAX_VALUE = 20;

    private double HUMIDITY_MIN_VALUE = 40;
    private double HUMIDITY_MAX_VALUE = 62;


    @Override
    public List<HardwareDto> getAllDevices() {
        List<HardwareDto> deviceList = hardwareRepo.findAll().stream()
                .map(hardware -> new HardwareDto(
                        hardware.getDeviceName(),
                        hardware.getSensorData()
                ))
                .toList();

        return deviceList;
        //return new DevicesDto(deviceList);
    }

    @Override
    public HardwareDto saveNewRecord(HardwareDto hardwareDto) {

        Hardware hardware = modelMapper.map(hardwareDto, Hardware.class);

        // Save to database
        hardware = hardwareRepo.save(hardware);

        // Convert back to DTO and return
        return modelMapper.map(hardware, HardwareDto.class);
    }

    @Scheduled(fixedRate = 2000)
    private void generateNextValue(){

        if(generateName) {
            name = randomNameAndTemp.generateDeviceName();
            generateName = false;
        }

        SensorData temp = randomNameAndTemp.generateTemperatureAndHumidity(
                TEMP_MIN_VALUE,
                TEMP_MAX_VALUE,
                HUMIDITY_MIN_VALUE,
                HUMIDITY_MAX_VALUE
        );

        HardwareDto savedDto = saveNewRecord(new HardwareDto(name, temp));

        template.convertAndSend("/topic/data", savedDto);
    }
}
