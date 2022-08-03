package com.robintegg.blend.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.robintegg.blend.aggregate.AggregatedContent;
import com.robintegg.blend.aggregate.AggregatedContentRepository;
import com.robintegg.blend.links.LinkRepository;
import com.robintegg.blend.podcasts.PodcastRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomepageController {

    private final AggregatedContentRepository aggregatedContentRepository;
    private final PodcastRepository podcastRepository;
    private final LinkRepository linkRepository;

    @GetMapping("/")
    public String getHome(Model model,
            @PageableDefault(size = 20, sort = "dateAdded", direction = Direction.DESC) Pageable pageable) {

        model.addAttribute("contentList", aggregatedContentRepository
                .findAll(pageable)
                .map(ac -> {
                    if ("link".equals(ac.getContentType())) {
                        return Content.of(ac.getContentType(), linkRepository.findById(ac.getId()).get());
                    } else {
                        return Content.of(ac.getContentType(), podcastRepository.findById(ac.getId()).get());
                    }
                }));

        return "index";
    }

}
