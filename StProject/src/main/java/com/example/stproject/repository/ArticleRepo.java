package com.example.stproject.repository;

import com.example.stproject.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article,Integer> {
}
