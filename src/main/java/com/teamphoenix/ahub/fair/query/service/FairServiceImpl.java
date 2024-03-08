package com.teamphoenix.ahub.fair.query.service;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;
import com.teamphoenix.ahub.fair.query.repository.FairMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "queryFairService")
@Slf4j
public class FairServiceImpl implements FairService {

    private final FairMapper fairMapper;
    @Autowired
    public FairServiceImpl(FairMapper fairMapper) {
        this.fairMapper = fairMapper;
    }

    /* 조회 : 사용자가 웹 브라우저에서 행사 정보 게시글을 클릭했을 때,
     * 해당 게시글의 게시글 번호(fair_id)를 조건으로
     * 게시글 번호, 제목, 내용, 작성일, 작성자 를 조회해 오는 메소드
     * */
    public FairDTO getFairPost(int fairId) {

        // fairId 의 밸류가 넘어와서 getPostNum 에 저장됨
        FairDTO result = fairMapper.getFairPost(fairId);
//        log.info("반환된 result 값 : {}", result);

        return result;
    }

    /* 페어 정보 게시판 입장 시 최초로 보이는 게시글들 (모든 게시글)을 조회하는 기능 -> 아래 메소드로 통합 */
    /* 페이징 처리 안돼 있으니 마이바티스 페이징 처리 알아본 다음에 개선할 것 */
//    public List<FairDTO> getAllPosts() {
//
//        List<FairDTO> result = fairMapper.selectAllPosts();
//        log.info("모든 리스트 반환 결과 : {}", result);
//
//        return result;
//    }

    /* 게시글 리스트 조회 기능 메소드
     * 컨트롤러로부터 받아온 조회 조건(searchInfo) 중 fairContent 와  fairTitle이 null 일 경우,
     *  = 아무런 조건이 없으면 모든 게시글 리스트 조회하는 쿼리문 실행
     * 이외의 경우(제목 검색, 내용 검색, 제목&내용 검색)
     *  = 조건에 맞게 리스트를 반환하는 쿼리문 실행
     *
     * 페어 게시글 화면을 클릭하면 무조건 이 메소드를 호출해서 전체 조회로 기본 화면을 띄운다.
     * 이후 조건이 추가되면 redirect시켜서 lists?sc="내용조건1"&st="제목조건1" 의 형태로 파라미터에 추가해서 다시
     * lists 로 보내고, 커맨드 객체에 해당 값들을 받아서 조건 검색 쿼리문을 실행한다.
     *
     * 이후 페이징 처리 필요
     * */
    public List<FairDTO> findPostsByCondition(FairDTO searchInfo) {

        List<FairDTO> result = fairMapper.selectPostsByCondition(searchInfo);
//            log.info("result 결과물 : {}", result);
        return result;

    }

}