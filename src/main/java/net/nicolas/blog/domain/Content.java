package net.nicolas.blog.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ElementCollection
    private List<String> images;

    public Content(){

    }

    public Content(String text){
        this.images = this.images = Arrays.asList("https://via.placeholder.com/350x150", "https://via.placeholder.com/350x150");
        this.text = text;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
