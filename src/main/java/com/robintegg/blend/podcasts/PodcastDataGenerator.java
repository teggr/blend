package com.robintegg.blend.podcasts;

import java.time.Instant;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PodcastDataGenerator implements ApplicationRunner {

    private final PodcastRepository podcastRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        if(podcastRepository.count() != 0) {
            log.info("Using existing podcast entries");
            return;
        }

        log.info("Adding podcasts");

        podcastRepository.save(new Podcast(null, "https://robintegg.com/", Instant.now(),  null, null));
        
    }
    
}
