package org.table.tableprojcet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/articles") //모든 종류의 http 요청을 처리하는데 사용
@Controller
public class ArticleController {

    @GetMapping
    public String articles(ModelMap map){
        map.addAttribute("articles", List.of());
        return "articles/index";
    }

    @GetMapping("/{articleId}")
    public String article(@PathVariable Long articleId, ModelMap map){
        map.addAttribute("article", "article"); //TODO 실제 데이터를 넣어줘야 함
        map.addAttribute("articleComments", List.of());
        return "articles/detail";
    }

}
