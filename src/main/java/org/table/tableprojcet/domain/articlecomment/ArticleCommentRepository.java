package org.table.tableprojcet.domain.articlecomment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.table.tableprojcet.domain.article.Article;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment , Long> {
}
