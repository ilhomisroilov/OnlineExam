package com.example.onlineexam;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TestWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received: " + message.getPayload());
        session.sendMessage(new TextMessage("Test qabul qilindi!"));
    }
}
