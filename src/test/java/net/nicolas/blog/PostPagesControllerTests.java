package net.nicolas.blog;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import net.nicolas.blog.controllers.PostPagesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PostPagesController.class)
public class PostPagesControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFetchPage() throws Exception {
        mockMvc.perform(get("/ajax/fetch"))
                .andExpect(status().isOk())
                .andExpect(view().name("publish_post_fetch"))
                .andExpect(content().string(
                        containsString("Create A New Post")
                ));
    }

    @Test
    public void testAjaxPage() throws Exception {
        mockMvc.perform(get("/ajax/ajax"))
                .andExpect(status().isOk())
                .andExpect(view().name("publish_post_ajax"))
                .andExpect(content().string(
                        containsString("Post a Blog")
                ));
    }
}
