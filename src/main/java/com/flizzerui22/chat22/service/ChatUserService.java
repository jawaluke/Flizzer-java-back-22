package com.flizzerui22.chat22.service;

import com.flizzerui22.chat22.model.ChatMessage;
import com.flizzerui22.chat22.model.ChatUser;
import com.flizzerui22.chat22.repository.ChatUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatUserService {

    @Autowired
    private ChatUserRepository chatUserRepository;

    public ChatUser getUserByUserName(String userName) {
        ChatUser ans = chatUserRepository.findByUserName(userName);
        return ans;
    }


    public ChatUser checkUser(String userName) {
        return chatUserRepository.findByUserName(userName);
    }


}