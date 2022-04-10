package com.flizzerui22.chat22.controller;

import com.flizzerui22.chat22.service.ChatUserService;
import com.flizzerui22.chat22.testutils.PopulateChatUserForTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;


@WebMvcTest(controllers = ChatController.class)
@AutoConfigureMockMvc
public class ChatControllerIntegrationTest {
 
    private ChatController chatController;
    
    @Autowired                           
    private MockMvc mockMvc; 

    @MockBean 
    private ChatUserService chatUserService;

    private PopulateChatUserForTest populateChatUserForTest;

    @BeforeEach
    void setUp() {
        populateChatUserForTest = new PopulateChatUserForTest();
    }

    @Test
    public void getChatUserByName() throws Exception{
        // GIVEN
        given(chatUserService.getUserByUserName("jawahar")).willReturn(populateChatUserForTest.populateChatUser());
        // WHEN
        // THEN
        this.mockMvc.perform(get("/user/jawahar"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.userMail").value("jawaharlakshmanan6@gmail.com"));
    }

    @Test
    void checkUserExistTest() throws Exception {
        // GIVEN
        String user = "jawahar";
        given(chatUserService.checkUser("jawahar")).willReturn(populateChatUserForTest.populateChatUser());
        // WHEN
        this.mockMvc.perform(get("/user/userExist/jawahar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("true"));
    }


    @Test
    void checkUserExistTestFalse() throws Exception {
        // GIVEN
        String user = "jaw";
        given(chatUserService.checkUser("jawahar")).willReturn(populateChatUserForTest.populateChatUser());
        // WHEN
        this.mockMvc.perform(get("/user/userExist/jaw"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("false"));
    }


}
