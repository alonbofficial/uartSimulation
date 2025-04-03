package com.uart.uartsimulation.application_package.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class UartService {

    private final SimpMessagingTemplate messagingTemplate;

    public UartService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void processUartData(String data) {
        // Process UART data
        String processedData = "Processed UART data: " + data;

        // Send to all subscribers
        messagingTemplate.convertAndSend("/topic/updates", processedData);
    }
}
