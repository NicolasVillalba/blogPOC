package net.nicolas.blog;

import net.nicolas.blog.domain.Post;
import net.nicolas.blog.repositories.PostsRepository;
import net.nicolas.blog.services.implementations.BasicBlogPostServiceImp;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class BlogPostServiceTests {

    @Mock
    private PostsRepository postsRepository;

    @InjectMocks
    private BasicBlogPostServiceImp blogPostService;

    @Before
    public void setUp(){
        Post p = new Post("My Post", LocalDateTime.now());
        when(postsRepository.findById(1L))
                .thenReturn(p);
    }

    @Test
    public void testService(){
        assertNotNull(blogPostService.get(1L));
        assertEquals(blogPostService.get(1L).getTitle(), "My Post");
    }

}
