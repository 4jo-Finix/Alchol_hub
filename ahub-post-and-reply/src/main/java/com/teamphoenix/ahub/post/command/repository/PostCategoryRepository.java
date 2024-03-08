package com.teamphoenix.ahub.post.command.repository;

import com.teamphoenix.ahub.post.command.aggregate.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer> {

    /* 설명. findAll 메소드를 사용할 수 있지만 jpql 또는 native sql로 작성할 수도 있음을 확인한다. */
    @Query(value="SELECT CATEGORY_ID, CATEGORY_NAME FROM post_category ORDER BY CATEGORY_ID ASC", nativeQuery = true)
    List<PostCategory> findAllCategory();
}
