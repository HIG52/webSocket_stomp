package com.example.websocketstomp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatControllerTest {

        @Test
        void testSendMessage() {
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setContent("Hello, World!");
            ChatController chatController = new ChatController();
            ChatMessage result = chatController.sendMessage(chatMessage);
            assertEquals(chatMessage, result);
        }

}