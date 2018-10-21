package net.nicolas.blog.services;

import net.nicolas.blog.domain.Post;

public interface BlogPostService {
    Post get(Long id);
}
