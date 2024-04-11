package org.table.tableprojcet.domain.articlecomment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.table.tableprojcet.domain.article.Article;

@RepositoryRestResource
public interface ArticleCommentRepository extends JpaRepository<ArticleComment , Long> {
}
