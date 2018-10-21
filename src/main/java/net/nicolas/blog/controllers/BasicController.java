package net.nicolas.blog.controllers;

import net.nicolas.blog.dtos.ResponseDTO;
import net.nicolas.blog.services.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    private NamesService nameService;

    @GetMapping("/")
    public ResponseDTO home(){
        return new ResponseDTO("message", nameService.get());
    }
}
