package net.nicolas.blog.services.implementations;

import net.nicolas.blog.services.FakerService;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

/**
 * Formal Implementation that uses
 * javaFaker lib
 */
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

    @Override
    public String textLine() {
        return faker.lorem().characters(15);
    }

    @Override
    public String paragraphText(Integer n) {
        return faker.lorem().paragraph(n);
    }

    @Override
    public String anyWord() {
        return faker.beer().name();
    }

    @Override
    public Integer anyDigit() {
        return faker.number().randomDigit();
    }

    @Override
    public String imageUrls() {
        return faker.avatar().image();
    }
}
