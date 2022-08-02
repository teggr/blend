package com.robintegg.blend.podcasts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PodcastsController {

    private final PodcastRepository podcastRepository;

    @GetMapping("/podcasts")
    public String getLinks(Model model, @PageableDefault(sort = "dateAdded", direction = Direction.DESC) Pageable pageable) {
        model.addAttribute("podcasts", podcastRepository.findAll(pageable));
        return "podcasts";
    }

}
