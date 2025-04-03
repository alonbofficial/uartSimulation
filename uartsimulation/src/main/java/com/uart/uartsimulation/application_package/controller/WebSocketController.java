package com.uart.uartsimulation.application_package.controller;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {

    @MessageMapping("/temperature")
    @SendTo("/topic/updates")
    public String processData(String data) {
        // Process your UART data here
        return "Processed data: " + data;
    }

    @MessageExceptionHandler
    public String handleException(Throwable exception) {
        return "Error: " + exception.getMessage();
    }

    /**
     * Receives and broadcasts updates via WebSocket.
     *
     * @param message The message received from the client.
     * @return A string indicating that an update was received, along with the received message.
     *         This message is then broadcast to all subscribers of the "/topic/updates" topic.
     */
//    @MessageMapping("/update")
//    @SendTo("/topic/updates")
//    public String sendUpdate(String message) {
//        return "Update received: " + message;
//    }
}