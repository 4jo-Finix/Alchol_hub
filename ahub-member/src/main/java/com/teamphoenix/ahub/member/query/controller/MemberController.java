package com.teamphoenix.ahub.member.query.controller;

import com.teamphoenix.ahub.member.query.service.MemberService;
import com.teamphoenix.ahub.member.query.vo.LoginResponseMember;
import com.teamphoenix.ahub.member.query.vo.MyProfileResponseMember;
import com.teamphoenix.ahub.member.query.dto.MemberDTO;
import com.teamphoenix.ahub.member.query.vo.RequestMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/findAllMembers")
    public List<MemberDTO> findAllMembers() {

        return memberService.selectAllMembers();
    }

     @GetMapping("/findByMemberCode/{memberCode}")
    public MemberDTO findByMemberCode(@PathVariable("memberCode") String memberCode) {

        return memberService.selectByMemberCode(memberCode);
    }

    @GetMapping("/findByMemberId/{memberId}")
    public MemberDTO findByMemberId(@PathVariable("memberId") String memberId) {

        return memberService.selectByMemberId(memberId);
    }

    @GetMapping("/findMyprofile/{memberId}")
    public ResponseEntity<MyProfileResponseMember> selectMyprofile(@PathVariable("memberId") String memberId) {


        MemberDTO myProfile = memberService.selectMyprofile(memberId);

        MyProfileResponseMember myProfileResponseMember = new MyProfileResponseMember();
        myProfileResponseMember.setMemberId(myProfile.getMemberId());
        myProfileResponseMember.setMemberName(myProfile.getMemberName());
        myProfileResponseMember.setMemberAddr(myProfile.getMemberAddr());
        myProfileResponseMember.setMemberEmail(myProfile.getMemberEmail());
        myProfileResponseMember.setMemberPhone(myProfile.getMemberPhone());
        myProfileResponseMember.setRestrictStartDate(myProfile.getRestrictStartDate());

        return ResponseEntity.status(HttpStatus.OK).body(myProfileResponseMember);
    }

    /* 설명. 회원 로그인에 security 적용하기 */
    @PostMapping("/findLogin")
    public ResponseEntity<LoginResponseMember> memberLogin(@RequestBody RequestMember login) {
        MemberDTO memberLoginInfo = modelMapper.map(login, MemberDTO.class);

        MemberDTO loginResult = memberService.memberLogin(memberLoginInfo);

        LoginResponseMember loginResponseMember = new LoginResponseMember();
        loginResponseMember.setMemberId(loginResult.getMemberId());
        loginResponseMember.setMemberName(loginResult.getMemberName());

        return ResponseEntity.status(HttpStatus.OK).body(loginResponseMember);
    }

    /* member_id list 반환하는 메소드 (Feign Client용) */
    @PostMapping("/request-list")
    public List<String> getWriterList(@RequestBody List<String> writerCodes) {

        List<Integer> findCode = new ArrayList<>();

        for (String code : writerCodes) {
            int condition = Integer.parseInt(code);
            findCode.add(condition);
        }

        return memberService.findMemberIdList(findCode);
    }

    @GetMapping("/request-code/{userId}")
    public int getWriterCode(@PathVariable("userId") String userId){
        MemberDTO memberDTO = memberService.selectByMemberId(userId);

        return memberDTO.getMemberCode();
    };

}
