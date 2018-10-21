package net.nicolas.blog.repositories;

import net.nicolas.blog.domain.Author;
import net.nicolas.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository  extends JpaRepository<Post, Long> {
    Post findById(Long i);
    List<Post> findByAuthor(Author i);
}
