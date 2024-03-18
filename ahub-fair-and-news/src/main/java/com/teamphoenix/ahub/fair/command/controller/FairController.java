package com.teamphoenix.ahub.fair.command.controller;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.service.FairService;
import com.teamphoenix.ahub.fair.command.vo.RequestModify;
import com.teamphoenix.ahub.fair.command.vo.RequestRegist;
import com.teamphoenix.ahub.fair.command.vo.ResponsePost;
import com.teamphoenix.ahub.fair.command.vo.ResponseStatus;
import io.jsonwebtoken.Claims;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    // 새 게시글 등록 핸들러 메소드
    @PostMapping("/new")
    public ResponseEntity<ResponseStatus> addNewPost(@RequestBody RequestRegist postInfo,
                                                     @RequestAttribute("claims") Claims idInfo,
                                                     @RequestParam(value = "", required = false) MultipartFile thumImage,
                                                     @RequestParam(value = "", required = false) List<MultipartFile> contentImages) {

        int writerCode = Integer.parseInt(idInfo.getAudience());

        System.out.println("postInfo = " + postInfo);
        LocalDate startDate = LocalDate.parse(postInfo.getFairStartdate());
        LocalDate endDate = LocalDate.parse(postInfo.getFairEnddate());

        // FairDTO에 화면으로 부터 입력받은 값 + 작성일, 사용여부, 작성자 멤버코드, 섬네일 이미지, 본문 이미지를 담음
        FairDTO newFairPost = modelMapper.map(postInfo, FairDTO.class);
        newFairPost.setFairWritedate(LocalDateTime.now());
        newFairPost.setUseAcceptance(1);
        newFairPost.setMemberCode(writerCode);
        newFairPost.setThumImage(thumImage);
        newFairPost.setContentImages(contentImages);
        newFairPost.setFairStartdate(startDate);
        newFairPost.setFairEnddate(endDate);
        System.out.println("newFairPost = " + newFairPost);

        FairDTO resultDTO = fairService.registFairPost(newFairPost);


        // 프론트에 반환할 때 날짜 -> 파싱해서 YYYY-MM-DD HH-MM-SS 로 바꾸기
        String writeDate = resultDTO.getFairWritedate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 이미지 -> 불러올 url string 으로 바꾸기
        List<String> imageSources = new ArrayList<>();      // 임시
        imageSources.add("www.google.com");

        ResponsePost result = new ResponsePost(resultDTO.getFairTitle(), resultDTO.getFairContent(),
                writeDate, resultDTO.getFairTag1(), resultDTO.getFairTag2(), resultDTO.getFairTag3(),
                resultDTO.getFairStartdate(), resultDTO.getFairEnddate(), resultDTO.getFairLocation(),
                resultDTO.getWriterInfo().getMemberId(), "S3 섬네일 이미지 경로", imageSources);

        ResponseStatus respMessage = createResponseStatus("201, CREATED"
                ,"Success to add new post. Post num [" + resultDTO.getFairId() + "]"
                ,"http://localhost:8000/board/fairs/lists"
                , result);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(respMessage);
    }

    // 기존 게시글 수정 핸들러 메소드
    // 수정 가능한 내용 : 제목 / 내용 / 개최 지역 / 개최 장소 / 시작일 / 종료일 / 태그
    @PutMapping("/{postNum}")
    public ResponseEntity<ResponseStatus> modifyFairPost(
            @PathVariable(value = "postNum") int postNum,
            @RequestBody RequestModify getInfo,
            @RequestAttribute("claims") Claims idInfo) {

        int writerCode = Integer.parseInt(idInfo.getAudience());

        FairDTO modifyInfo = modelMapper.map(getInfo, FairDTO.class);
        modifyInfo.setMemberCode(writerCode);
        modifyInfo.setFairWritedate(LocalDateTime.now());

        // 수정 후 결과값 반환
        FairDTO resultDTO = fairService.modifyFairPost(postNum, modifyInfo);

        // 프론트에 반환할 때 날짜 -> 파싱해서 YYYY-MM-DD HH-MM-SS 로 바꾸기
        String writeDate = resultDTO.getFairWritedate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 이미지 -> 불러올 url string 으로 바꾸기
        List<String> imageSources = new ArrayList<>();      // 임시
        imageSources.add("www.google.com");

        ResponsePost result = new ResponsePost(resultDTO.getFairTitle(), resultDTO.getFairContent(),
                writeDate, resultDTO.getFairTag1(), resultDTO.getFairTag2(), resultDTO.getFairTag3(),
                resultDTO.getFairStartdate(), resultDTO.getFairEnddate(), resultDTO.getFairLocation(),
                resultDTO.getWriterInfo().getMemberId(), "S3 섬네일 이미지 경로", imageSources);

        ResponseStatus respMessage = createResponseStatus("200, OK"
                ,"Success to modify [" + postNum + "] fair post."
                ,"http://localhost:8000/board/fairs/lists"
                ,result);

        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);
    }

    // 게시글 삭제 메소드
    @DeleteMapping("/{postNum}")
    public ResponseEntity<ResponseStatus> removeFairPost(@PathVariable("postNum") int postNum) {

        fairService.removeFairPost(postNum);

        ResponseStatus respMessage = createResponseStatus("200, OK"
                ,"Success to delete [" + postNum + "] fair post."
                ,"http://localhost:8000/board/fairs/lists"
                ,null);

        return ResponseEntity
                .status(HttpStatus.OK).body(respMessage);
    }

    // 응답 메세지 생성 메소드
    private ResponseStatus createResponseStatus(String httpStatus, String message, String url, ResponsePost result) {
        return new ResponseStatus(httpStatus.toString(), message, url, result);
    }
}
