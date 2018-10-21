package net.nicolas.blog.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String about;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> entries;

    public Author(){
        this.fullName = "Jhon Doe";
        this.about = "Once upon a time this guy writed shomething";
        this.entries = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(min = 5, max = 30)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Size(max = 300)
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Post> getEntries() {
        return entries;
    }

    public void setEntries(List<Post> entries) {
        this.entries = entries;
    }
}
