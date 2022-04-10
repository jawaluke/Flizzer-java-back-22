package com.flizzerui22.chat22.service;

import com.flizzerui22.chat22.Mapper.UserRecordMapper;
import com.flizzerui22.chat22.Response.UserMessagesResponse;
import com.flizzerui22.chat22.Response.UserRecordsResponse;
import com.flizzerui22.chat22.model.ChatMessage;
import com.flizzerui22.chat22.model.ChatUser;
import com.flizzerui22.chat22.repository.ChatMessageRepository;
import com.flizzerui22.chat22.repository.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private ChatUserRepository chatUserRepository;

    private UserRecordMapper userRecordMapper = new UserRecordMapper();


    public UserRecordsResponse getAllRecordsOfUser(String userName) {
        List<UserMessagesResponse> userMessagesResponseList = new ArrayList<>();
        List<ChatMessage> chatMessageList = chatMessageRepository.findMessagesOfUser(userName);
        List<String> usersList = userRecordMapper.mapWithUsersAndRecords(chatMessageList, userName);
        for(String i : usersList) {

            userMessagesResponseList.add(UserMessagesResponse.builder()
                    .chatUser(chatUserRepository.findByUserName(i))
                    .chatMessageList(getAllRecordBetweenTheUser(i, userName))
                    .build());

        }

        return userRecordMapper.mapToUserRecordResponse(getAllChatUser(usersList), chatMessageList, userMessagesResponseList);
    }

    public List<ChatUser> getAllChatUser(List<String> userNames) {
        return chatUserRepository.getAllUserByListUserName(userNames);
    }

    public List<ChatMessage> getAllRecordBetweenTheUser(String sender, String receiver) {
        return chatMessageRepository.findMessagesBetweenTheUsers(sender, receiver);
    }

    public ChatMessage postMessageToDB(String sender, String receiver, String msg, String time, String tag) {
        System.out.println("inside service post");
        return chatMessageRepository.save(ChatMessage.builder()
                .chatId((int) (chatMessageRepository.count()+1))
                .sender(sender)
                .receiver(receiver)
                .message(msg)
                .times(time)
                .messageTag(ChatMessage.MessageTag.valueOf(tag))
                .build());
    }
}
