package com.teamphoenix.ahub.query.mapper;

import com.teamphoenix.ahub.query.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    List<MemberDTO> selectAllMembers();

    MemberDTO selectByMemberCode(int memberCode);

    MemberDTO selectByMemberId(String memberId);

    MemberDTO selectMyprofile(String memberId);

    MemberDTO memberLogin(Map<String, String> memberLogin);
}
