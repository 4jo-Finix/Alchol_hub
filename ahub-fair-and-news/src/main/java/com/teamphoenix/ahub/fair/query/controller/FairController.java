package com.teamphoenix.ahub.fair.query.controller;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;
import com.teamphoenix.ahub.fair.query.service.FairService;
import com.teamphoenix.ahub.fair.query.vo.ResponseFindPost;
import com.teamphoenix.ahub.fair.query.vo.ResponseList;
import com.teamphoenix.ahub.fair.query.vo.ResponseSearchList;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController(value = "queryFairController")
@RequestMapping("/fairs")
@Slf4j
public class FairController {

    private final FairService fairService;
    private final ModelMapper modelMapper;

    @Autowired
    public FairController(FairService fairServiceImpl, ModelMapper modelMapper) {
        this.fairService = fairServiceImpl;
        this.modelMapper = modelMapper;
    }

    // 게시글을 클릭하면 내용을 호출하는 핸들러 메소드
    @GetMapping("/{postId}")
    public ResponseEntity<ResponseFindPost> findFairPost(@PathVariable(value = "postId") int postId) {

        FairDTO fairDTO = fairService.getFairPost(postId);
        ResponseList respMessage = modelMapper.map(fairDTO, ResponseList.class);

        ResponseFindPost result = new ResponseFindPost();
        result.setCode("200, OK");
        result.setMessage("Success to Read [" + postId + "] fair post.");
        result.setUrl("http://localhost:8000/board/fairs/lists");
        result.setResult(respMessage);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    // 검색 조건에 해당하는 게시글 리스트 반환하는 메소드
    @GetMapping("/lists")
    public ResponseEntity<ResponseSearchList> findPostsByCondition(
            @RequestParam(value = "st", required = false) String title,
            @RequestParam(value = "sc", required = false) String content,
            @RequestParam(value = "tc", required = false) String titleContent,
            @RequestParam(value = "id", required = false) String id) {

        FairDTO searchInfo = new FairDTO(title, content, id);

        if (titleContent != null) {
            searchInfo.setFairTitle(titleContent);
            searchInfo.setFairContent(titleContent);
        }

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

    // List<FairDTO>를 List<ResponseList> 로 바꿔주는 메소드
    private List<ResponseList> doDTOToList(List<FairDTO> fairList) {
        List<ResponseList> responseLists = new ArrayList<>();
        for (FairDTO fairDTO : fairList) {
            ResponseList responseList = modelMapper.map(fairDTO, ResponseList.class);
            String returnString = fairDTO.getFairContent().substring(0, Math.min(fairDTO.getFairContent().length(), 30));
            responseList.setFairContent(returnString);
            String writeDate = fairDTO.getFairWritedate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            responseList.setFairWritedate(writeDate);

            responseLists.add(responseList);
        }

        return responseLists;
    }

}
