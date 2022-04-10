package com.flizzerui22.chat22.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    @Id
    private int chatId;

    private String message;
    private String sender;
    private String receiver;

    @Enumerated(EnumType.STRING)
    private MessageTag messageTag;

    private String times;

    public enum MessageTag {
        NONE, EDITED, DELETED, VIDEOCALL, HIDDEN;
    }

}
