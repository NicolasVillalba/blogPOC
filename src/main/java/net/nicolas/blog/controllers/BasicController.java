package net.nicolas.blog.controllers;

import net.nicolas.blog.dtos.PostDTO;
import net.nicolas.blog.dtos.ResponseDTO;
import net.nicolas.blog.services.NamesService;
import net.nicolas.blog.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/")
public class BasicController {

    @Autowired
    private NamesService nameService;

    @Autowired
    private PostsService postsService;

    @GetMapping("/")
    public ResponseDTO home(){
        return new ResponseDTO("message", nameService.get());
    }

    @PostMapping("/post")
    public ResponseDTO createPost(@RequestBody PostDTO post){
        postsService.save(post);
        return new ResponseDTO("message", "posted");
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createPostEnhanced(@RequestBody PostDTO post){
        postsService.save(post);
         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(new ResponseDTO("message", "posted"));
    }
}
