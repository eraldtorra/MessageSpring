package com.example.messagespring.repo;

import com.example.messagespring.entity.DirectChats;
import com.example.messagespring.model.DirectChatsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirectChatsRepository extends JpaRepository<DirectChats, Long> {

    @Query("SELECT dc FROM DirectChats dc WHERE dc.user1.id = :userId OR dc.user2.id = :userId")
    public List<DirectChats> findAllByUserId(@Param("userId") Long userId);


}
