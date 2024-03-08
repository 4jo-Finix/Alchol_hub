package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import org.springframework.data.jpa.repository.Query;

public interface FairService {
    void removeFairPost(int postNum);

    void modifyFairPost(int postNum, FairDTO modifyInfo);

    FairDTO registFairPost(FairDTO newFairPost);
}
