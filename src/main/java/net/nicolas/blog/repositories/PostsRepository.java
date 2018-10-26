package net.nicolas.blog.repositories;

import net.nicolas.blog.domain.Author;
import net.nicolas.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository  extends JpaRepository<Post, Long> {
    Post findById(Long i);

    @Query("select p from Post p where p.author.id = ?1")
    List<Post> findAuthorPostsByID(Long author_id);

    @Query("select p from Post p where p.title like %?1%")
    List<Post> searchPostsTitles(String query);
}
