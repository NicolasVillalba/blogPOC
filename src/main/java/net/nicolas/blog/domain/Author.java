package net.nicolas.blog.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String about;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Post> entries;

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

    @Size(max = 150)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Size(max = 2000)
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Post> getEntries() {
        return entries;
    }

    public void setEntries(Set<Post> entries) {
        this.entries = entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(fullName, author.fullName) &&
                Objects.equals(about, author.about) &&
                Objects.equals(entries, author.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, about, entries);
    }
}
