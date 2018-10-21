package net.nicolas.blog.services.implementations;

import net.nicolas.blog.services.FakerService;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class FakerServiceImp implements FakerService {

    private Faker faker = new Faker();

    @Override
    public String fullName() {
        return faker.name().fullName();
    }

    public String sportsHeadLine() {
        String s = faker.esports().game() + faker.esports().player();
        return String.format("%s1 %s2", faker.esports().game(), faker.esports().player());
    }
}
