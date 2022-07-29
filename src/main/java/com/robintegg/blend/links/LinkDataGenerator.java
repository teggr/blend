package com.robintegg.blend.links;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class LinkDataGenerator implements ApplicationRunner {

    private final LinkRepository linkRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        if(linkRepository.count() != 0) {
            log.info("Using existing database entries");
            return;
        }

        log.info("Adding links");

        linkRepository.save(new Link(null, "https://robintegg.com/"));
        
    }
    
}
