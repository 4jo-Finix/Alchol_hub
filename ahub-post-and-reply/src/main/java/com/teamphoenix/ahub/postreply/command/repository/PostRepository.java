package com.teamphoenix.ahub.postreply.command.repository;

import com.teamphoenix.ahub.postreply.command.aggregate.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value="SELECT m FROM Post m ORDER BY m.postId ASC")
    List<Post> findAllOrderedByPostId();

    Post findByPostId(int postId);
}
