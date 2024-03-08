package com.teamphoenix.ahub.fair.query.controller;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;
import com.teamphoenix.ahub.fair.query.service.FairService;
import com.teamphoenix.ahub.fair.query.vo.ResponseFindPost;
import com.teamphoenix.ahub.fair.query.vo.ResponseList;
import com.teamphoenix.ahub.fair.query.vo.ResponseSearchList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController(value = "queryFairController")
@RequestMapping("/fairs")
@Slf4j
public class FairController {

    private final FairService fairService;

    @Autowired
    public FairController(FairService fairService) {
        this.fairService = fairService;
    }

    /* 게시글을 클릭하면 내용을 호출하는 핸들러 메소드 */
    @GetMapping("/{postId}")
    public ResponseEntity<ResponseFindPost> findFairPost(@PathVariable(value = "postId") int postId) {

        FairDTO fairDTO = fairService.getFairPost(postId);

        ResponseFindPost result = new ResponseFindPost();
        result.setCode("200, OK");
        result.setMessage("Success to Read [" + postId + "] fair post.");
        result.setUrl("http://localhost:8000/board/fairs/lists");
        result.setResult(fairDTO);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    /* 게시글 전체 리스트&검색어를 파라미터로 던질 시 해당 검색어에 해당하는 리스트를 반환하는 핸들러 메소드 */
    @GetMapping("/lists")
    public ResponseEntity<ResponseSearchList> findPostsByCondition(
            @RequestParam(value = "st", required = false) String title,
            @RequestParam(value = "sc", required = false) String content) {

        FairDTO searchInfo = new FairDTO(title, content);
        List<FairDTO> resultList = fairService.findPostsByCondition(searchInfo);
        List<ResponseList> responseLists = doDTOToList(resultList);



        ResponseSearchList result = new ResponseSearchList();
        result.setCode("200, OK");
        result.setMessage("Success to Read list.");
        result.setUrl("http://localhost:8000/board/fairs/{postId}");
        result.setResult(responseLists);

        return ResponseEntity
                .ok()
                .body(result);
    }

    private List<ResponseList> doDTOToList(List<FairDTO> fairList) {
        List<ResponseList> responseLists = new ArrayList<>();
        for (FairDTO fairDTO : fairList) {
            ResponseList responseList = new ResponseList();
            responseList.setFairId(fairDTO.getFairId());
            responseList.setFairTitle(fairDTO.getFairTitle());
            responseList.setFairWritedate(fairDTO.getFairWritedate());

            responseLists.add(responseList);
        }

        return responseLists;
    }
}