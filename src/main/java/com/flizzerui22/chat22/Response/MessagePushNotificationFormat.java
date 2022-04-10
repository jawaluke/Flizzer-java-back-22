package com.flizzerui22.chat22.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessagePushNotificationFormat {

    private String sender;
    private String receiver;
    private String message;
    private String time;

}
