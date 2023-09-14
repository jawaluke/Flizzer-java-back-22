package com.flizzerui22.chat22.controller;

import com.flizzerui22.chat22.model.ChatMessage;
import com.flizzerui22.chat22.model.ChatUser;
import com.flizzerui22.chat22.service.ChatMessageService;
import com.flizzerui22.chat22.service.ChatUserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class ChatController {


    @Autowired
    private ChatUserService chatUserService;


    @GetMapping("/info")
    public String greetInfo(){
        System.out.println("Greetings page");
        log.info("user entered to welcome page");
        return "Welcome to flizzer chatUI22";
    }    

    @GetMapping("/user/{userName}")
    public ChatUser getUserByName(@PathVariable("userName") String userName) {
        log.info("user getting username");
        System.out.println("user getting username");
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