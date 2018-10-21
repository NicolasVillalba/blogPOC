package net.nicolas.blog.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Boolean draft;
    private LocalDateTime published;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Content content;
    @ElementCollection
    private List<String> tags;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Author author;
    private Integer rating;

    public Post(){

    }

    public Post(String title, LocalDateTime published) {
        this.title = title;
        this.draft = true;
        this.published = published;
        this.content = new Content("My very interesting content, dont miss this");
        this.tags = Arrays.asList("Tech", "Techies");
        this.author = new Author();
        this.rating = 3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
