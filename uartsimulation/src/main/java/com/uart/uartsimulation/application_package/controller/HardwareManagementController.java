package com.uart.uartsimulation.application_package.controller;

import com.uart.uartsimulation.application_package.dto.HardwareDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import com.uart.uartsimulation.application_package.service.IHardwareService;

import java.util.List;

/**
 * This controller handles requests related to hardware management.
 * It provides endpoints for retrieving all devices and saving new device records.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "app/hardware")
public class HardwareManagementController {

    //Todo: Add error handling

    private final IHardwareService hardwareService;

    /**
     * Retrieves all hardware devices.
     *
     * @return ResponseEntity containing a list of HardwareDto objects and an HTTP status of OK (200).
     */
    @GetMapping("/get_all_devices")
    public ResponseEntity<List<HardwareDto>> getTasks(){
        return new ResponseEntity<>(hardwareService.getAllDevices(), HttpStatus.OK);
    }

    /**
     * Saves a new hardware record.
     *
     * @param hardwareDto The HardwareDto object containing the data to be saved.
     *                    It is validated using the @Valid annotation.
     * @return ResponseEntity containing the result of the save operation and an HTTP status of OK (200).
     */
    @PostMapping("/save_new_data")
    public ResponseEntity<?> saveNewRecord(@RequestBody @Valid HardwareDto hardwareDto){
        return new ResponseEntity<>(hardwareService.saveNewRecord(hardwareDto), HttpStatus.OK);
    }
}