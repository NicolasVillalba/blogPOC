package net.nicolas.blog.listeners;

import net.nicolas.blog.domain.Author;
import net.nicolas.blog.domain.Content;
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

    private PostsRepository postsRepository;

    private FakerService fakerService;

    public DataSeederListener(PostsRepository postsRepository, FakerService fakerService){
        this.postsRepository = postsRepository;
        this.fakerService = fakerService;
    }

    @EventListener
    public void seedDataOnH2(ContextRefreshedEvent event){
        System.out.println(":::::::::::::::::SEEDING DB::::::::::::::::::::");
        for (int i = 0; i < 20; i++){
            Post p = new Post(fakerService.sportsHeadLine(), LocalDateTime.now());
            Author author = new Author();
            author.setFullName(fakerService.fullName());
            author.setAbout(fakerService.paragraphText(1));

            Content content = new Content(fakerService.paragraphText(2));
            content.getImages().add(fakerService.imageUrls());
            content.getImages().add(fakerService.imageUrls());
            content.getImages().add(fakerService.imageUrls());
            p.setAuthor(author);
            p.setContent(content);
            p.getTags().add(fakerService.anyWord());
            p.getTags().add(fakerService.anyWord());
            p.getTags().add(fakerService.anyWord());
            p.setRating(fakerService.anyDigit());
            postsRepository.save(p);
        }
    }
}
