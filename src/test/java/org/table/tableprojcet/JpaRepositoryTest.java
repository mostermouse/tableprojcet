package org.table.tableprojcet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.table.tableprojcet.config.JpaConfig;
import org.table.tableprojcet.domain.article.Article;
import org.table.tableprojcet.domain.article.ArticleRepository;
import org.table.tableprojcet.domain.articlecomment.ArticleCommentRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
public class JpaRepositoryTest {
    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired
            ArticleRepository articleRepository,
            @Autowired
            ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }
    @DisplayName("select 테스트")
    @Test
    void selectTest() {
        //given

        //when
        List<Article> articles = articleRepository.findAll();
        //then
        assertThat(articles).isNotNull().hasSize(0);
    }

    @DisplayName("insert 테스트")
    @Test
    void insertTest(){
        //given
        long previousCount = articleRepository.count();


        //when
       Article savedArticle =  articleRepository.save(Article.of("new article" , "new content" , "#spring"));

        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount +1);
    }

    @DisplayName("update 테스트")
    @Test
    void updateTest(){
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);


        //when
        Article savedArticle = articleRepository.saveAndFlush(article);
        //then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag" , updatedHashtag);
    }

    @DisplayName("delete 테스트")
    @Test
    void deleteTest(){
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        long deletedCommentsSize = article.getArticleComments().size();

        //when
        articleRepository.delete(article);

        //then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount -1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentsSize);
    }
}
