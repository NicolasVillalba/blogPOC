package net.nicolas.blog.repositories;

import net.nicolas.blog.domain.Post;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTests {

    @Autowired
    private PostsRepository postRepo;

    @Test
    public void findAllPostsTest(){
        assertNotNull(postRepo.findAll());
    }

    @Test
    public void saveAPostTest(){
        postRepo.save(new Post("My Post", LocalDateTime.now()));
        assertTrue(postRepo.findAll().size() <= 21);
    }

    @Test
    public void postTitleTest(){
        Post p = postRepo.findById(1L);
        assertTrue(p.getTitle().length() > 0);
        assertTrue(p.getContent().getText().length() > 0);
    }

    @Test
    public void authorFullNameTest(){
        Post p = postRepo.findById(5L);
        assertNotNull(p.getAuthor().getFullName());
        assertTrue(p.getAuthor().getFullName().length() > 0);
    }

    @Test
    public void searchPostsByAuthorID(){
        List<Post> posts = postRepo.findAuthorPostsByID(3L);
        System.out.println(posts.get(0));
        assertNotNull("Repository has some thing",posts);
        assertTrue("At least one element",posts.size() > 0);
    }

    @Test
    public void serachPostsByTitle(){
        List<Post> posts = postRepo.searchPostsTitles("as");
        System.out.println(posts.size());
        assertNotNull(posts);
    }
}