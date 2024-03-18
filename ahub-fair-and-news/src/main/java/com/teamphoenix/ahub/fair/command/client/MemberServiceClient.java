package com.teamphoenix.ahub.fair.command.client;

import com.teamphoenix.ahub.fair.command.vo.ResponseMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "member-service", url="localhost:8000")
public interface MemberServiceClient {

    @GetMapping("/member/findByMemberCode/{memberCode}")
    ResponseMember getWriterInfo(@PathVariable("memberCode") int memberCode);

    @PostMapping("/member/request-list")
    List<String> getWriterList(@RequestBody List<String> writerCodes);

    @GetMapping("/member/request-code/{userId}")
    int getWriterCode(@PathVariable("userId") String userId);
}
