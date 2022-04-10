package com.flizzerui22.chat22.Response;

import com.flizzerui22.chat22.model.ChatMessage;
import com.flizzerui22.chat22.model.ChatUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserMessagesResponse {

    private ChatUser chatUser;
    private List<ChatMessage> chatMessageList;

}
