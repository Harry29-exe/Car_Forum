package com.harry.Audio_Forum.backend.pojo;

import javax.persistence.*;

@Entity
@Table(name="post")
public class Post {

    public Post(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public Post() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "author", nullable = false)
    private String author;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
