package net.nicolas.blog.services.implementations;

import net.nicolas.blog.domain.Author;
import net.nicolas.blog.domain.Content;
import net.nicolas.blog.domain.Post;
import net.nicolas.blog.dtos.PostDTO;
import net.nicolas.blog.repositories.PostsRepository;
import net.nicolas.blog.services.PostsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostsServiceImpl implements PostsService {

    private PostsRepository postsRepository;

    public PostsServiceImpl( PostsRepository repo){
        this.postsRepository = repo;
    }

    @Override
    public void save(PostDTO postDTO) {
        Post p = new Post(postDTO.getTitle(), LocalDateTime.now());
        Content c = new Content(postDTO.getText());
        p.setDraft(true);
        p.setContent(c);
        p.setAuthor(new Author());
        postsRepository.save(p);
    }
}