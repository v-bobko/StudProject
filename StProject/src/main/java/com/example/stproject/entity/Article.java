package com.example.stproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="title")
    private String title;
    @Column(name ="anons")
    private String anons;
    @Column(name ="text")
    private String text;

    public Article() {
    }

    public Article(String title, String anons, String text) {
        this.title = title;
        this.anons = anons;
        this.text = text;
    }
}
