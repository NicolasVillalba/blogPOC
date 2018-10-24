package net.nicolas.blog.services;

import net.nicolas.blog.dtos.PostDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceImplTest {

    @Autowired
    private PostsService postsService;

    @Test
    public void save() {
        PostDTO pdto = new PostDTO();
        pdto.setTitle("Conan The Barbarian");
        pdto.setText("Was a movie protagonisized for Arnold S.");
        postsService.save(pdto);
    }
}