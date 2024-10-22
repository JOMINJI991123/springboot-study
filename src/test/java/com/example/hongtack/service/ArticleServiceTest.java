package com.example.hongtack.service;

import com.example.hongtack.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired ArticleService articleService;
    @Test
    void index() {
        Article a = new Article(1L,"가가가","나나");
        Article b = new Article(2L,"가가","나나");
        Article c = new Article(3L,"가","나나");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));

        List<Article> articles = articleService.index();

        assertEquals(expected.toString(), articles.toString());

    }

    @Test
    @Transactional
    void show_success() {
        Long id = 1l;

        Article expected = new Article(id,"rrrr","rrr");

        Article article = articleService.show(id);

        assertEquals(expected,article);
    }



}