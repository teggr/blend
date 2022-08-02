package com.robintegg.blend.podcasts;

import java.time.Instant;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddPodcastController {

    private final PodcastMetadata podcastMetadata;
    private final PodcastRepository podcastRepository;

    @GetMapping("/add-podcast")
    public String getAddLink(
            Model model) {

        model.addAttribute("addPodcastForm", new AddPodcastForm(null, null));

        return "add-podcast";

    }

    @PostMapping("/add-podcast")
    public String postAddLink(
            @Valid @ModelAttribute AddPodcastForm addPodcastForm,
            BindingResult result) {

        FeedData feedData = podcastMetadata.getFeedData(addPodcastForm.getFeedUrl());

        podcastRepository.save(
                new Podcast(null, addPodcastForm.getFeedUrl(), Instant.now(), feedData, addPodcastForm.getTagsAsSet()));

        return "redirect:/podcasts";

    }

}
