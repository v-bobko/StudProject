package com.example.stproject.controller;

import com.example.stproject.entity.Article;
import com.example.stproject.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ArticleRepo articleRepo;

    //Начальные страницы
    @GetMapping("/blog")
    public String blog(Model model) {
        Iterable<Article> articles=articleRepo.findAll();
        model.addAttribute("article",articles);
        return "index";
    }

    @GetMapping("/blog/add")
    public String blogAdd() {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogAddPost(@RequestParam String title, @RequestParam String anons, @RequestParam String text,Model model) {
        Article article=new Article(title,anons,text);
        articleRepo.save(article);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") int id, Model model){
        if(!articleRepo.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Article> article=articleRepo.findById(id);
        ArrayList<Article> res=new ArrayList<>();
        article.ifPresent(res::add);
        model.addAttribute("article",res);
        return "blog-details";

    }

    @GetMapping("/blog/{id}/del")
    public String blogDelPost(@PathVariable(value = "id") int id, Model model) {
        Article article=articleRepo.findById(id).orElseThrow();
        articleRepo.delete(article);
        return "redirect:/blog";
    }


}