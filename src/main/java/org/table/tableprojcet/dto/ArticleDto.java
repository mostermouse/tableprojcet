package org.table.tableprojcet.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(
        LocalDateTime createdAt,
        String createdBy,
        String title,
        String content,
        String hashtag
)implements Serializable //직렬화 바이트 스트림 형태로 연속적인 데이터로 변환하는 포맷 변환 기술
{
    public static ArticleDto of(LocalDateTime createdAt, String createdBy, String title, String content, String hashtag) {
       return new ArticleDto(createdAt, createdBy, title, content, hashtag);
    }
}
