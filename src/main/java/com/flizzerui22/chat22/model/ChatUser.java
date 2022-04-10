package com.flizzerui22.chat22.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChatUser {
    
    @Id
    private int userId;
    
    private String userName;
    private String userMail;
    private String userPassword;
    private ArrayList<String> users;
}