package com.teamphoenix.ahub.member.command.controller;

import com.teamphoenix.ahub.member.command.dto.MemberDTO;
import com.teamphoenix.ahub.member.command.service.MemberService;
import com.teamphoenix.ahub.member.command.vo.RequestMember;
import com.teamphoenix.ahub.member.command.vo.ResponseMember;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController("memberController2")
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    /* 회원 가입 */
    @PostMapping("/regist")
    public ResponseEntity<ResponseMember> registMember(@RequestBody RequestMember newMember) {
        MemberDTO newMemberInfo = modelMapper.map(newMember, MemberDTO.class);
        newMemberInfo.setMemberCategoryId(2);
        newMemberInfo.setRestrictStartDate(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy년MM월dd일"))));

        memberService.registMember(newMemberInfo);
        String newMemberId = newMemberInfo.getMemberId();

        log.info("컨트롤러에서 입력받은 회원가입 정보: {}", newMemberInfo);

        ResponseMember responseMember = new ResponseMember();
        responseMember.setMemberId(newMemberId);
        responseMember.setMessage(newMemberId + "님 회원 가입이 완료되었습니다.");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMember);
    }

    /* 회원 정보 수정 */
    @PutMapping("/modify/{memberId}")
    public ResponseEntity<ResponseMember> modifyMember(@PathVariable("memberId") String memberId, @RequestBody MemberDTO modifyMemberInfo) {
        modifyMemberInfo.setRestrictStartDate(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy년MM월dd일"))));
        modifyMemberInfo.setMemberCategoryId(2);

        String CurrentMemberId = modifyMemberInfo.getMemberId();
        int memberCode = memberService.modifyMember(CurrentMemberId, modifyMemberInfo);
        modifyMemberInfo.setMemberCode(memberCode);

        ResponseMember responseMember = new ResponseMember();
        responseMember.setMemberId(CurrentMemberId);
        responseMember.setMessage(CurrentMemberId + "님 회원 정보 수정 완료");

        return ResponseEntity.status(HttpStatus.OK).body(responseMember);
    }

    /* 회원 탈퇴 기능 */
    @DeleteMapping("/remove/{memberId}")
    public ResponseEntity<ResponseMember> removeMember(@PathVariable("memberId") String memberId) {
        memberService.removeMember(memberId);

        ResponseMember responseMember = new ResponseMember();
        responseMember.setMemberId(memberId);
        responseMember.setMessage("회원 탈퇴 완료");

        return ResponseEntity.status(HttpStatus.OK).body(responseMember);
    }

}
