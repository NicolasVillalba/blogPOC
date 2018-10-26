package net.nicolas.blog.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.*;

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
    private Set<String> tags = new HashSet<>();
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Author author;
    private Integer rating;

    public Post(){

    }

    public Post(String title, LocalDateTime published) {
        this.title = title;
        this.draft = false;
        this.published = published;
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

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(draft, post.draft) &&
                Objects.equals(published, post.published) &&
                Objects.equals(content, post.content) &&
                Objects.equals(tags, post.tags) &&
                Objects.equals(author, post.author) &&
                Objects.equals(rating, post.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, draft, published, content, tags, author, rating);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", draft=" + draft +
                ", published=" + published +
                ", content=" + content +
                ", tags=" + tags +
                ", author=" + author +
                ", rating=" + rating +
                '}';
    }
}
