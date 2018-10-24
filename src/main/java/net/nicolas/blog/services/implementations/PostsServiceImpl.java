package net.nicolas.blog.services.implementations;

import net.nicolas.blog.domain.Author;
import net.nicolas.blog.domain.Content;
import net.nicolas.blog.domain.Post;
import net.nicolas.blog.dtos.PostDTO;
import net.nicolas.blog.repositories.PostsRepository;
import net.nicolas.blog.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public void save(PostDTO postDTO) {
        Post p = new Post(postDTO.getTitle(), null);
        Content c = new Content(postDTO.getText());
        p.setDraft(true);
        p.setContent(c);
        p.setAuthor(new Author());
        postsRepository.save(p);
    }
}