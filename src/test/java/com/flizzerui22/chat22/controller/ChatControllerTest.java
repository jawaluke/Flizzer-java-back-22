package com.flizzerui22.chat22.controller;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatControllerTest {

    ChatController chatController;

    @BeforeEach
    public void init() {
        chatController = new ChatController();
    }

    @Test
    void testGreetInfo() {
        // Given
        // When
        String actual = chatController.greetInfo();
        // Then
        Assertions.assertEquals("Welcome to flizzer chatUI22", actual);
    }




}
