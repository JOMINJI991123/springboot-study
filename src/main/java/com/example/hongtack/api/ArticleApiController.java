package com.example.hongtack.api;

import com.example.hongtack.dto.ArticleForm;
import com.example.hongtack.entity.Article;
import com.example.hongtack.repository.ArticleRepository;
import com.example.hongtack.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;

    //get
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable("id") Long id){
        return articleService.show(id);
    }

    //post
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto);
        return (created != null ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

//    //patch
//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@PathVariable("id") Long id,
//                                          @RequestBody ArticleForm dto){
//        Article article = dto.toEntity();
//        Article target = articleRepository.findById(id).orElse(null);
//
//        if(target == null || article.getId() != id){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        target.patch(article);
//        Article updated= articleRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
//    //delete
//    @DeleteMapping("/apt/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable("id") Long id){
//        Article target = articleRepository.findById(id).orElse(null);
//
//        if(target == null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        articleRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).body(null);
//    }
}
