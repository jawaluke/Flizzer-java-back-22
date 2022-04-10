package com.flizzerui22.chat22.Mapper;

import com.flizzerui22.chat22.Response.UserMessagesResponse;
import com.flizzerui22.chat22.Response.UserRecordsResponse;
import com.flizzerui22.chat22.model.ChatMessage;
import com.flizzerui22.chat22.model.ChatUser;
import com.flizzerui22.chat22.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRecordMapper {

    @Autowired
    private ChatUserService chatUserService;

    public List<String> mapWithUsersAndRecords(List<ChatMessage> allRecordsOfUser, String userName) {
        List<String> chatUsers = new ArrayList<>();
        for(ChatMessage i: allRecordsOfUser) {
            if(!(i.getReceiver().equals(userName))) {
                System.out.println("userName +\"\"+i.getReceiver() = " + userName +""+i.getReceiver());
                chatUsers.add(i.getReceiver());
            }
            else{
                chatUsers.add(i.getSender());
            }
        }

        return chatUsers.stream().distinct().collect(Collectors.toList());
    }


    public UserRecordsResponse mapToUserRecordResponse(List<ChatUser> allChatUser, List<ChatMessage> chatMessageList, List<UserMessagesResponse> userMessagesResponseList) {
        System.out.println("allChatUser = " + allChatUser);
        return UserRecordsResponse.builder()
                .chatUsers(allChatUser)
                .chatMessageList(chatMessageList)
                .userMessagesResponses(userMessagesResponseList)
                .build();
    }




}
