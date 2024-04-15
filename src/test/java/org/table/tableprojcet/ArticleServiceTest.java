package org.table.tableprojcet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.table.tableprojcet.domain.article.ArticleRepository;
import org.table.tableprojcet.domain.type.SearchType;
import org.table.tableprojcet.dto.ArticleDto;
import org.table.tableprojcet.service.ArticleService;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
@DisplayName("비지니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;  //mock 생성자 주입 애노테이션
    @Mock private ArticleRepository articleRepository; //그 외 mock 생성자 주입 애노테이션
    /*검색
    * 각 게시글 페이지로 이동
    * 페이지네이션
    * 홈 버튼 -> 게시판 페이지로 리다이렉션
    * 정렬 기능*/
    @DisplayName("게시글 검색하면 게시글 리스트 반환")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList() {
        //given

        //when
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); //제목, 본문 , id, 닉네임 , 해시태그
        //then
        assertThat(articles).isNotNull();

    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle(){
        ArticleDto articles = sut.searchArticle(1L);

        assertThat(articles).isNotNull();
    }


}
