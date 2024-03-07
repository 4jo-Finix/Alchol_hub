package com.teamphoenix.ahub.command.service;

import com.teamphoenix.ahub.command.dto.MemberDTO;

public interface MemberService {

    void registMember(MemberDTO newMemberInfo);

    int modifyMember(String memberId, MemberDTO modifyMember);

    void removeMember(String memberId);
}
