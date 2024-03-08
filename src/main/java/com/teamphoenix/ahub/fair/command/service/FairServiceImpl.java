package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.aggregate.Fair;
import com.teamphoenix.ahub.fair.command.repository.FairRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service(value = "CommandFairService")
@Slf4j
public class FairServiceImpl implements FairService {


    private final FairRepository fairRepository;
    private final ModelMapper  modelMapper;

    @Autowired
    public FairServiceImpl(FairRepository fairRepository, ModelMapper modelMapper) {
        this.fairRepository = fairRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public FairDTO registFairPost(FairDTO fairInfo) {

        Fair fair = new Fair(
                fairInfo.getFairTitle(),
                fairInfo.getFairContent(),
                fairInfo.getFairWritedate(),
                fairInfo.getUseAcceptance(),
                fairInfo.getMemberCode()) ;

        fairRepository.save(fair);
        fair = fairRepository.findByFairTitle(fairInfo.getFairTitle());

        FairDTO result = new FairDTO(
                fair.getFairId(),
                fair.getFairTitle(),
                fair.getFairContent(),
                fair.getFairWritedate(),
                fair.getUseAcceptance(),
                fair.getMemberCode()
        );

        return result;
    }

    /* 게시글 수정 메소드 */
    @Transactional
    public void modifyFairPost(int postNum, FairDTO modifyInfo) {

        Fair oldPost = fairRepository.findById(postNum).orElseThrow(IllegalArgumentException::new);
        oldPost.setFairTitle(modifyInfo.getFairTitle());
        oldPost.setFairContent(modifyInfo.getFairContent());
        oldPost.setFairWritedate(modifyInfo.getFairWritedate());

    }

    /* 게시글 삭제 메소드 */
    public void removeFairPost(int postNum) {

        fairRepository.deleteById(postNum);
    }
}
