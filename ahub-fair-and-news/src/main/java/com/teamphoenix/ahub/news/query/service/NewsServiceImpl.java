package com.teamphoenix.ahub.news.query.service;

// 같은 Member Project로 FeignClient 요청을 날려야 하지만,
// 같은 이름을 가진 FeignClient 는 두개 생성할 수 없어서 fair 프로젝트에 생성한 클래스를 빌려옴.
import com.teamphoenix.ahub.fair.command.client.MemberServiceClient;
import com.teamphoenix.ahub.fair.command.vo.ResponseMember;
import com.teamphoenix.ahub.news.query.dto.NewsDTO;
import com.teamphoenix.ahub.news.query.repository.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("queryNewsService")
public class NewsServiceImpl implements NewsService {

    private final NewsMapper newsMapper;

    private final MemberServiceClient memberServiceClient;

    @Autowired
    public NewsServiceImpl(NewsMapper newsMapper,
                           MemberServiceClient memberServiceClient) {
        this.newsMapper = newsMapper;
        this.memberServiceClient = memberServiceClient;
    }

    public NewsDTO getNewsPost(int newsId) {

        NewsDTO result = newsMapper.getNewsPost(newsId);

        ResponseMember responseMember = memberServiceClient.getWriterInfo(result.getMemberCode());
        result.setWriterId(responseMember.getMemberId());

        return result;
    }


    public List<NewsDTO> findPostsByCondition(NewsDTO searchInfo) {

        if (searchInfo.getWriterId() != null) {
            String writerId = searchInfo.getWriterId();
            int searchCode = memberServiceClient.getWriterCode(writerId);
            searchInfo.setMemberCode(searchCode);
        }

        List<NewsDTO> result = newsMapper.selectPostsByCondition(searchInfo);
        System.out.println("result = " + result);
        List<String> codeList = new ArrayList<>();

        for (NewsDTO newsDTO : result) {
            String writerCode = String.valueOf(newsDTO.getMemberCode());

            codeList.add(writerCode);
        }

        List<String> idList = memberServiceClient.getWriterList(codeList);

        for (int i = 0; i < result.size(); i++) {

            NewsDTO newsDTO = result.get(i);
            newsDTO.setWriterId(idList.get(i));
        }
        System.out.println("result = " + result);
        return result;
    }
}