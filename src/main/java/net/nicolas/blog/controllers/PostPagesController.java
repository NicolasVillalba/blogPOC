package net.nicolas.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostPagesController {
    @GetMapping("/ajax/{ajaxType}")
    public String postPage(@PathVariable String ajaxType){
        if(ajaxType.equalsIgnoreCase("fetch"))
            return "publish_post_fetch";
        if(ajaxType.equalsIgnoreCase("jquery"))
            return "publish_post_jquery";
        return "publish_post_ajax";
    }
}
