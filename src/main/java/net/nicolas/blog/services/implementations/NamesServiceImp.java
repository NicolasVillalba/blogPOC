package net.nicolas.blog.services.implementations;

import net.nicolas.blog.services.NamesService;
import org.springframework.stereotype.Service;

@Service
public class NamesServiceImp implements NamesService {
    @Override
    public String get() {
        return "Carl";
    }
}
