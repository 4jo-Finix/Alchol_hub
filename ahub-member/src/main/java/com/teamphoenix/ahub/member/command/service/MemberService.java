package com.teamphoenix.ahub.member.command.service;

import com.teamphoenix.ahub.member.command.dto.MemberDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    void registMember(MemberDTO newMemberInfo);

    int modifyMember(String memberId, MemberDTO modifyMember);

    void removeMember(String memberId);
}
