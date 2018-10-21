package net.nicolas.blog.listeners;

import net.nicolas.blog.domain.Post;
import net.nicolas.blog.repositories.PostsRepository;
import net.nicolas.blog.services.FakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataSeederListener {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private FakerService fakerService;

    @EventListener
    public void seedDataOnH2(ContextRefreshedEvent event){
        System.out.println(":::::::::::::::::SEEDING DB::::::::::::::::::::");
        for (int i = 0; i < 20; i++){
            Post p = new Post(fakerService.sportsHeadLine(), LocalDateTime.now());
            postsRepository.save(p);
        }
    }
}
