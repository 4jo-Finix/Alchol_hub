package com.teamphoenix.ahub.fair.query.service;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;

import java.util.List;

public interface FairService {
    FairDTO getFairPost(int postId);

    List<FairDTO> findPostsByCondition(FairDTO searchInfo);
}
