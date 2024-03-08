package com.teamphoenix.ahub.member.command.repository;

import com.teamphoenix.ahub.member.command.aggregate.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberInfo, Integer> {
    MemberInfo findByMemberCode(int memberCode);

    MemberInfo findByMemberId(String memberId);
}
