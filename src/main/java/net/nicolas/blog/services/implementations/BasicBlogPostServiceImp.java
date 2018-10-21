package net.nicolas.blog.services.implementations;

import net.nicolas.blog.domain.Post;
import net.nicolas.blog.repositories.PostsRepository;
import net.nicolas.blog.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicBlogPostServiceImp implements BlogPostService {

    private PostsRepository repo;

    @Autowired
    public BasicBlogPostServiceImp(PostsRepository repo){
        this.repo = repo;
    }

    @Override
    public Post get(Long id) {
        return repo.findById(id);
    }
}
