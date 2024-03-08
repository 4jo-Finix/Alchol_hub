package com.teamphoenix.ahub.post.query.service;

import com.teamphoenix.ahub.post.query.dto.PostDTO;
import com.teamphoenix.ahub.post.query.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "query postService")
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    /* 조회 : 사용자가 웹 브라우저에서 행사 정보 게시글을 클릭했을 때,
     * 해당 게시글의 게시글 번호(post_id)를 조건으로
     * 게시글 번호, 제목, 내용, 작성일, 작성자 를 조회해 오는 메소드
     * */
    public PostDTO getPost(int postId) {

        // postId 의 밸류가 넘어와서 getPostNum 에 저장됨
        PostDTO result = postMapper.getPost(postId);
//        log.info("반환된 result 값 : {}", result);

        return result;
    }



    public List<PostDTO> findPostsByCondition(PostDTO searchInfo) {
        List<PostDTO> result = postMapper.selectPostsByCondition(searchInfo);
        return result;

    }

}