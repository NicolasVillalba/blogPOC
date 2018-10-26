package net.nicolas.blog.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ElementCollection
    private Set<String> images = new HashSet<>();

    public Content(){

    }

    public Content(String text){
        this.setText(text);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(id, content.id) &&
                Objects.equals(text, content.text) &&
                Objects.equals(images, content.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, images);
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", images=" + images +
                '}';
    }
}
