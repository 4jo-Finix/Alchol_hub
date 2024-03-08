package com.teamphoenix.ahub.member.query.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "post-and-reply-service", url = "localhost:10000")
public interface PostAndReplyServiceClient {
    /* post and reply의 카테고리 아이디 조회 메소드의 주소값 확인 후 수정 */
    @GetMapping("/post-and-reply-service/post/category/{categoryId}")
    /* post and reply 서비스의 해당 메소드가 반환한 값을 반환형으로 설정 */
    int getCategoryId(@PathVariable("categoryId") int categoryId);

}
