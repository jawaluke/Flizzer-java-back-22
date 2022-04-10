package com.flizzerui22.chat22.controller;

import com.flizzerui22.chat22.model.ChatMessage;
import com.flizzerui22.chat22.model.ChatUser;
import com.flizzerui22.chat22.service.ChatMessageService;
import com.flizzerui22.chat22.service.ChatUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("https://flizzer-lakshmanan-ui.herokuapp.com/")
public class ChatController {


    @Autowired
    private ChatUserService chatUserService;


    @GetMapping("/info")
    public String greetInfo(){
        return "Welcome to flizzer chatUI22";
    }    

    @GetMapping("/user/{userName}")
    public ChatUser getUserByName(@PathVariable("userName") String userName) {
        return chatUserService.getUserByUserName(userName);
    }


    @GetMapping("/user/userExist/{userName}")
    public Boolean checkUserExist(@PathVariable("userName") String userName) {
        if (chatUserService.checkUser(userName) == null) {
            return false;
        }
        return true;
    }



}