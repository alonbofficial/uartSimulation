package com.uart.uartsimulation.application_package.controller;

import com.uart.uartsimulation.application_package.service.IRandomNameAndTemp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "app/random")
public class RandomNameAndTempController {

    private final IRandomNameAndTemp randomNameAndTemp;

    @GetMapping
    public String getRandomString() {
        return "Latest Random String: " + randomNameAndTemp.generateTemperatureAndHumidity(10, 20, 40, 65);
    }
}
