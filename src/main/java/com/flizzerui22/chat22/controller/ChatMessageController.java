package com.flizzerui22.chat22.controller;

import com.flizzerui22.chat22.Mapper.UserRecordMapper;
import com.flizzerui22.chat22.Response.MessagePushNotificationFormat;
import com.flizzerui22.chat22.Response.SendMessageFormat;
import com.flizzerui22.chat22.Response.UserRecordsResponse;
import com.flizzerui22.chat22.model.ChatMessage;
import com.flizzerui22.chat22.service.ChatMessageService;
import com.flizzerui22.chat22.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("https://flizzer-lakshmanan-ui.herokuapp.com/")
@RestController
public class ChatMessageController {
    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private ChatUserService chatUserService;

    private UserRecordMapper userRecordMapper = new UserRecordMapper();

    @Autowired
    private SimpMessagingTemplate messageTemplate;

    @GetMapping("/user/{userName}/records")
    public UserRecordsResponse getUserMessageRecords(@PathVariable("userName") String userName) {
        if(chatUserService.checkUser(userName)!=null){
            return chatMessageService.getAllRecordsOfUser(userName);        }
        return UserRecordsResponse.builder().build();
    }

    @PostMapping("/user/message/send/")
    public Boolean sendMessage(@RequestBody SendMessageFormat sendMessageFormat) {

        // Need to notifiy receiver through web socket
        MessagePushNotificationFormat pushNotificationFormat = MessagePushNotificationFormat.builder()
                .sender(sendMessageFormat.getSender())
                .receiver(sendMessageFormat.getReceiver())
                .message(sendMessageFormat.getMessage())
                .time(sendMessageFormat.getTimes())
                .build();


        chatMessageService.postMessageToDB(sendMessageFormat.getSender(),
                sendMessageFormat.getReceiver(),
                sendMessageFormat.getMessage(),
                sendMessageFormat.getTimes(),
                sendMessageFormat.getMessageTag());

        messageTemplate.convertAndSendToUser(sendMessageFormat.getSender(),"/queue/messagesNotify",pushNotificationFormat);
        messageTemplate.convertAndSendToUser(sendMessageFormat.getReceiver(),"/queue/messagesNotify",pushNotificationFormat);

        return true;
    }





}

