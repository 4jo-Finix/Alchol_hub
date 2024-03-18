package com.teamphoenix.ahub.fair.query.service;

import com.teamphoenix.ahub.fair.command.client.MemberServiceClient;
import com.teamphoenix.ahub.fair.command.vo.ResponseMember;
import com.teamphoenix.ahub.fair.query.dto.FairDTO;
import com.teamphoenix.ahub.fair.query.repository.FairMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "queryFairService")
@Slf4j
public class FairServiceImpl implements FairService {

    private final FairMapper fairMapper;
    private final MemberServiceClient memberServiceClient;

    @Autowired
    public FairServiceImpl(FairMapper fairMapper,
                           MemberServiceClient memberServiceClient) {
        this.fairMapper = fairMapper;
        this.memberServiceClient = memberServiceClient;
    }

    /* 조회 : 사용자가 웹 브라우저에서 행사 정보 게시글을 클릭했을 때,
     * 해당 게시글의 게시글 번호(fair_id)를 조건으로
     * 게시글 번호, 제목, 내용, 작성일, 작성자 를 조회해 오는 메소드
     * */
    public FairDTO getFairPost(int fairId) {

        FairDTO result = fairMapper.getFairPost(fairId);

        ResponseMember responseMember = memberServiceClient.getWriterInfo(result.getMemberCode());

        result.setWriterId(responseMember.getMemberId());

        return result;
    }

    public List<FairDTO> findPostsByCondition(FairDTO searchInfo) {

        if (searchInfo.getWriterId() != null) {
            String writerId = searchInfo.getWriterId();
            int searchCode = memberServiceClient.getWriterCode(writerId);
            searchInfo.setMemberCode(searchCode);
        }

        List<FairDTO> result = fairMapper.selectPostsByCondition(searchInfo);

        List<String> codeList = new ArrayList<>();

        for (FairDTO fairDTO : result) {
            String writerCode = String.valueOf(fairDTO.getMemberCode());

            codeList.add(writerCode);
        }

        List<String> idList = memberServiceClient.getWriterList(codeList);


        for (int i = 0; i < result.size(); i++) {

            FairDTO fairDTO = result.get(i);
            fairDTO.setWriterId(idList.get(i));
        }

        return result;
    }
}