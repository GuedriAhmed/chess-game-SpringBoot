package com.example.chess.resource;


import com.example.chess.service.ConnectedUserService;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
public class WebSocketController {

    private final ConnectedUserService connectedUserService;

    public WebSocketController(ConnectedUserService connectedUserService) {
        this.connectedUserService = connectedUserService;
    }

    @MessageMapping("/join")
    @SendTo("/topic/connected")
    public Set<String> join(String username) {
        connectedUserService.addUser(username);
        return connectedUserService.getConnectedUsers();
    }

    @MessageMapping("/leave")
    @SendTo("/topic/connected")
    public Set<String> leave(String username) {
        connectedUserService.removeUser(username);
        return connectedUserService.getConnectedUsers();
    }
}
