package com.teamphoenix.ahub.fair.command.controller;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.service.FairService;
import com.teamphoenix.ahub.fair.command.vo.RequestRegist;
import com.teamphoenix.ahub.fair.command.vo.ResponseStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController(value = "fairCommandController")
@RequestMapping("/fairs")
public class FairController {

    private final FairService fairService;
    private final ModelMapper modelMapper;

    @Autowired
    public FairController(FairService fairService, ModelMapper modelMapper) {
        this.fairService = fairService;
        this.modelMapper = modelMapper;
    }

    /* 새 게시글 등록 핸들러 메소드 */
    @PostMapping("/new")
    public ResponseEntity<ResponseStatus> addNewPost(@RequestBody RequestRegist postInfo) {

        FairDTO newFairPost = modelMapper.map(postInfo, FairDTO.class);
        newFairPost.setFairWritedate(LocalDateTime.now());
        newFairPost.setUseAcceptance(1);
        newFairPost.setMemberCode(1);

        FairDTO result = fairService.registFairPost(newFairPost);

        ResponseStatus respMessage = new ResponseStatus();
        respMessage.setCode("201, CREATED");
        respMessage.setMessage("Success to add new post.");
        respMessage.setUrl("http://localhost:8000/board/fairs/lists");
        respMessage.setResult(result);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(respMessage);
    }

    /* 기존 게시글 수정 핸들러 메소드 */
    @PutMapping("/{postNum}")
    public ResponseEntity<ResponseStatus> modifyFairPost(
            @PathVariable(value = "postNum") int postNum,
            @RequestBody FairDTO modifyInfo) {

        modifyInfo.setFairWritedate(LocalDateTime.now());

        fairService.modifyFairPost(postNum, modifyInfo);

        ResponseStatus respMessage = new ResponseStatus();
        respMessage.setCode("200, OK");
        respMessage.setMessage("Success to update [ " + postNum + " ] fair post.");
        respMessage.setUrl("http://localhost:8000/board/fairs/lists");
        respMessage.setResult(modifyInfo);

        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);

    }


    /* 게시글 삭제 */
    @DeleteMapping("/{postNum}")
    public ResponseEntity<ResponseStatus> removeFairPost(@PathVariable("postNum") int postNum) {

        fairService.removeFairPost(postNum);

        ResponseStatus respMessage = new ResponseStatus();
        respMessage.setCode("200, OK");
        respMessage.setMessage("Success to delete [ " + postNum + " ] fair post.");
        respMessage.setUrl("http://localhost:8000/board/fairs/lists");

        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);
    }
}
