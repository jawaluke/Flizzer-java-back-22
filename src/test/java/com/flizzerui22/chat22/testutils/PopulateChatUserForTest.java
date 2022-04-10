package com.flizzerui22.chat22.testutils;

import com.flizzerui22.chat22.model.ChatUser;

public class PopulateChatUserForTest {

    public ChatUser populateChatUser() {
        return ChatUser.builder()
        .userId(1)
        .userName("jawahar")
        .userMail("jawaharlakshmanan6@gmail.com")
        .userPassword("jawahar")
        .build();
    }

    
}