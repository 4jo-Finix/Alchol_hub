package com.teamphoenix.ahub.member.command.service;

import com.teamphoenix.ahub.member.command.aggregate.MemberInfo;
import com.teamphoenix.ahub.member.command.dto.MemberDTO;
import com.teamphoenix.ahub.member.command.repository.MemberRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository,
                             ModelMapper modelMapper,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /* 회원 가입 */
    @Transactional
    @Override
    public void registMember(MemberDTO newMemberInfo) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MemberInfo memberInfo = modelMapper.map(newMemberInfo, MemberInfo.class);

        memberInfo.setMemberPwd(bCryptPasswordEncoder.encode(newMemberInfo.getMemberPwd()));
        System.out.println("memberInfo = " + memberInfo);
        memberRepository.save(memberInfo);

    }

    /* memberId를 통해 해당 회원의 memberCode를 가져오는 코드 */
    @Transactional
    public int getMemberCode(String memberId){
        System.out.println("memberId = " + memberId);
        MemberInfo memberInfo = memberRepository.findByMemberId(memberId);
        System.out.println("memberInfo = " + memberInfo);
        return memberInfo.getMemberCode();
    }

    /* 회원 정보 수정 */
    @Transactional
    @Override
    public int modifyMember(String memberId, MemberDTO modifyMember) {

        int memberCode = getMemberCode(memberId);

        MemberInfo modifyValue = memberRepository.findById(memberCode)
                .orElseThrow(
                        () -> { return new NotFoundException("존재하지 않는 사용자입니다.");}
                );
        modifyValue.setMemberName(modifyMember.getMemberName());
        modifyValue.setMemberPwd(modifyMember.getMemberPwd());
        modifyValue.setMemberEmail(modifyMember.getMemberEmail());
        modifyValue.setMemberAddr(modifyMember.getMemberAddr());
        modifyValue.setMemberPhone(modifyMember.getMemberPhone());

        return memberCode;
    }

    /* 회원 탈퇴 기능 */
    @Override
    @Transactional
    public void removeMember(String memberId) {

        int memberCode = getMemberCode(memberId);

        memberRepository.deleteById(memberCode);
    }

    // 토큰 발급을 위한 memberId 가져오는 메소드 추가
    @Override
    public MemberDTO getUserDetailsByUserId(String memberId) {
        MemberInfo memberInfo = memberRepository.findByMemberId(memberId);
        if(memberInfo == null)
            throw new UsernameNotFoundException(memberId);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        MemberDTO memberDTO = mapper.map(memberInfo, MemberDTO.class);

        return memberDTO;
    }

    @Override
    public MemberDTO searchMember(String memberId) {

        MemberInfo memberInfo = memberRepository.findByMemberId(memberId);
        MemberDTO memberDTO = modelMapper.map(memberInfo, MemberDTO.class);

        return memberDTO;
    }
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        MemberInfo memberInfo = memberRepository.findByMemberId(memberId);

        if (memberInfo == null) {
            throw new UsernameNotFoundException(memberId + " 유저는 존재하지 않습니다.");
        }

        return new User(memberInfo.getMemberId(), memberInfo.getMemberPwd(),
                true, true, true, true,
                new ArrayList<>());
    }


}
