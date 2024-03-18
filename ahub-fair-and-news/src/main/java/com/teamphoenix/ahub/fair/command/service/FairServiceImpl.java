package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.aggregate.Fair;
import com.teamphoenix.ahub.fair.command.client.MemberServiceClient;
import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.repository.FairRepository;
import com.teamphoenix.ahub.fair.command.vo.ResponseMember;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "CommandFairService")
@Slf4j
public class FairServiceImpl implements FairService {

    private final FairRepository fairRepository;
    private final ModelMapper  modelMapper;
    private final MemberServiceClient memberServiceClient;

    @Autowired
    public FairServiceImpl(FairRepository fairRepository,
                           ModelMapper modelMapper,
                           MemberServiceClient memberServiceClient) {
        this.fairRepository = fairRepository;
        this.modelMapper = modelMapper;
        this.memberServiceClient = memberServiceClient;
    }

    // 게시글 등록 메소드
    @Transactional
    public FairDTO registFairPost(FairDTO fairInfo) {

        /* Setter를 사용하지 않고 생성자로 FairDTO -> Fair Entity 매핑 */
        Fair fair = new Fair(fairInfo.getFairTitle(),
                fairInfo.getFairContent(),
                fairInfo.getFairWritedate(),
                fairInfo.getUseAcceptance(),
                fairInfo.getFairTag1(),
                fairInfo.getFairTag2(),
                fairInfo.getFairTag3(),
                fairInfo.getFairStartdate(),
                fairInfo.getFairEnddate(),
                fairInfo.getFairLocation(),
                fairInfo.getFairArea(),
                fairInfo.getMemberCode()) ;

        // fair 테이블에 저장
        fairRepository.save(fair);

        // fair테이블로부터 저장된 내용 불러옴
        fair = fairRepository.findByFairTitle(fairInfo.getFairTitle());
        /* 전달 받은 섬네일 이미지, 본문 이미지를 사진 테이블에 보내는 로직(Feign/Kafka) 필요 */
        // 이미지 저장은 S3로 하고, 사진 테이블에는 원본 파일명, 저장된 S3주소, 리네임된 파일명, 사용된 fairID만 저장함
        /* 로직 추가 할 것 */


        // 불러온 객체 DTO로 변환함
        FairDTO returnDTO = new FairDTO (fair.getFairId(), fair.getFairTitle(), fair.getFairContent(),
                fair.getFairWritedate(), fair.getFairStartdate(), fair.getFairEnddate(), fair.getFairTag1(),
                fair.getFairTag2(), fair.getFairTag3(), fair.getFairLocation(), fair.getMemberCode());

        // 반환할 DTO에 저장된 사진 경로 추가하는 부분 필요

        ResponseMember memberInfo = memberServiceClient.getWriterInfo(returnDTO.getMemberCode());
        returnDTO.setWriterInfo(memberInfo);

        return returnDTO;
    }

    /* 게시글 수정 메소드 */
    @Transactional
    public FairDTO modifyFairPost(int postNum, FairDTO modifyInfo) {

        Fair oldPost = fairRepository.findById(postNum).orElseThrow(IllegalArgumentException::new);    // postNum에 해당하는 게시글 불러와서 영속성 컨텍스트에 스냅샷 객체로 저장
        oldPost.setFairTitle(modifyInfo.getFairTitle());
        oldPost.setFairContent(modifyInfo.getFairContent());
        oldPost.setFairWritedate(modifyInfo.getFairWritedate());
        oldPost.setFairTag1(modifyInfo.getFairTag1());
        oldPost.setFairTag2(modifyInfo.getFairTag2());
        oldPost.setFairTag3(modifyInfo.getFairTag3());
        oldPost.setFairLocation(modifyInfo.getFairLocation());
        oldPost.setFairArea(modifyInfo.getFairArea());
        oldPost.setFairStartdate(modifyInfo.getFairStartdate());
        oldPost.setFairEnddate(modifyInfo.getFairEnddate());

        FairDTO result = modelMapper.map(oldPost, FairDTO.class);


        fairRepository.save(oldPost);
        // 페인 클라이언트로 정보 읽어온다
        ResponseMember memberVO = memberServiceClient.getWriterInfo(modifyInfo.getMemberCode());

        result.setWriterInfo(memberVO);

        return result;

    }

    /* 게시글 삭제 메소드 */
    @Transactional
    public void removeFairPost(int postNum) {

        fairRepository.deleteById(postNum);
    }


}
