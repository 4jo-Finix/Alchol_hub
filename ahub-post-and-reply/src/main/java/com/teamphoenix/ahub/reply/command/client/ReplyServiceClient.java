package com.teamphoenix.ahub.reply.command.client;


import com.teamphoenix.ahub.reply.command.vo.MemberResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="member-service", url="localhost:8000")
public interface ReplyServiceClient {
    @GetMapping("/member-service/member/findByMemberCode/{memberCode}")
    MemberResponse getMemberName(@PathVariable("memberCode") int memberCode);
}
