package com.teamphoenix.ahub.news.command.service;

import com.teamphoenix.ahub.news.command.aggregate.News;
import com.teamphoenix.ahub.news.command.dto.NewsDTO;
import com.teamphoenix.ahub.news.command.repository.NewsRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CommandNewsService")
@Slf4j
public class NewsServiceImpl implements NewsService {


    private final NewsRepository newsRepository;
    private final ModelMapper  modelMapper;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, ModelMapper modelMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public NewsDTO registNewsPost(NewsDTO newsInfo) {

        News news1 = modelMapper.map(newsInfo,News.class) ;

        System.out.println("===================================================");
        System.out.println("news1 = " + news1);

        newsRepository.save(news1);
        news1  = newsRepository.findByNewsTitle(newsInfo.getNewsTitle());

        NewsDTO result = new NewsDTO(
                news1.getNewsId(),
                news1.getNewsTitle(),
                news1.getNewsContent(),
                news1.getNewsWritedate(),
                news1.getUseAcceptance(),
                news1.getMemberCode()
        );

        return result;
    }

    /* 게시글 수정 메소드 */
    @Transactional
    public void modifyNewsPost(int postNum, NewsDTO modifyInfo) {

        News oldPost = newsRepository.findById(postNum).orElseThrow(IllegalArgumentException::new);
        oldPost.setNewsTitle(modifyInfo.getNewsTitle());
        oldPost.setNewsContent(modifyInfo.getNewsContent());
        oldPost.setNewsWritedate(modifyInfo.getNewsWritedate());

        System.out.println("===================여기까지 오나?==============================");
    }

    /* 게시글 삭제 메소드 */
    public void removeNewsPost(int postNum) {

        newsRepository.deleteById(postNum);
    }

}
