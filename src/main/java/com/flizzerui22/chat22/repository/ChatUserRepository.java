package com.flizzerui22.chat22.repository;

import com.flizzerui22.chat22.model.ChatUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatUserRepository extends JpaRepository<ChatUser, Integer>, CrudRepository<ChatUser, Integer>{

    ChatUser findByUserName(String user);


    Boolean existsByUserName(String userName);

    @Query(value = "SELECT * FROM Chat_User u WHERE u.user_name in ?1", nativeQuery = true)
    List<ChatUser> getAllUserByListUserName(List<String> userNames);

}