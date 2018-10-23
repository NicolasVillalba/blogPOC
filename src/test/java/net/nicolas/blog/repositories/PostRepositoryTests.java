package net.nicolas.blog.repositories;

import net.nicolas.blog.domain.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTests {

    @Autowired
    private PostsRepository postRepo;

    @Test
    public void findAllPostsTest(){
        Assert.assertNotNull(postRepo.findAll());
    }

    @Test
    public void saveAPostTest(){
        postRepo.save(new Post("My Post", LocalDateTime.now()));
        Assert.assertTrue(postRepo.findAll().size() <= 21);
    }

    @Test
    public void postTitleTest(){
        Post p = postRepo.findById(1L);
        Assert.assertTrue(p.getTitle().length() > 0);
        Assert.assertTrue(p.getContent().getText().length() > 0);
    }

    @Test
    public void authorFullNameTest(){
        Post p = postRepo.findById(5L);
        Assert.assertNotNull(p.getAuthor().getFullName());
        Assert.assertTrue(p.getAuthor().getFullName().length() > 0);
    }

}