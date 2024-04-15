package org.table.tableprojcet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.table.tableprojcet.domain.article.ArticleRepository;
import org.table.tableprojcet.domain.type.SearchType;
import org.table.tableprojcet.dto.ArticleDto;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor //초기화 되자않은 final 필드나, @NonNull이 붙은 필드에 대해 생성자 생성
@Service
@Transactional //트랜잭션 원자성으로 처리해줌
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true) //트랜잭션 관리 애노테이션으로 readOnly 읽기 전용만 허용
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {
        return Page.empty();


    }
    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;

    }
}
