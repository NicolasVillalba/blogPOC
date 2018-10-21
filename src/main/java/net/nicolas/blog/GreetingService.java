package net.nicolas.blog;

import net.nicolas.blog.services.NamesService;

class GreetingService {

    private NamesService namesService;

    GreetingService(NamesService ns){
        super();
        this.namesService = ns;
    }

    String greet(){
        return "Hello " + namesService.get();
    }
}
