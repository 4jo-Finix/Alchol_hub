package com.teamphoenix.ahub.reply.command.repository;



import com.teamphoenix.ahub.reply.command.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
