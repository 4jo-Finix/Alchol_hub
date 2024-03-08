package com.teamphoenix.ahub.fair.command.repository;

import com.teamphoenix.ahub.fair.command.aggregate.Fair;
import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FairRepository extends JpaRepository<Fair, Integer> {

    @Query("SELECT f FROM Fair f WHERE f.fairTitle = :title")
    Fair findByFairTitle(@Param("title") String title);
}
