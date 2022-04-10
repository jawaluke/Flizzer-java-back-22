package com.flizzerui22.chat22.repository;

import com.flizzerui22.chat22.model.ChatMessage;
import com.flizzerui22.chat22.model.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer>, CrudRepository<ChatMessage, Integer> {


    @Query(value="SELECT * FROM Chat_Message u WHERE u.receiver = ?1 or u.sender = ?1",nativeQuery=true)
    List<ChatMessage> findMessagesOfUser(String userName);


    @Query(value="SELECT * FROM Chat_Message u WHERE (u.receiver = ?1 and u.sender = ?2) or (u.receiver = ?2 and u.sender = ?1)",nativeQuery=true)
    List<ChatMessage> findMessagesBetweenTheUsers(String sender, String receiver);
}
