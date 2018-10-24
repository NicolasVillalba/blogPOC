package net.nicolas.blog.services;

import net.nicolas.blog.dtos.PostDTO;

public interface PostsService {
    void save(PostDTO postDTO);
}