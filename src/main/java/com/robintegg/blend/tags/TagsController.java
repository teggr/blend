package com.robintegg.blend.tags;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TagsController {

    private final EntityManager entityManager;

    @GetMapping("/tags")
    public String getTags(Model model) {

        List<String> linkTags = entityManager
                .createQuery("SELECT DISTINCT t FROM Link l JOIN l.tags t", String.class)
                .getResultList();

        List<String> podcastTags = entityManager
                .createQuery("SELECT DISTINCT t FROM Podcast p JOIN p.tags t", String.class)
                .getResultList();

        List<String> allTags = new ArrayList<>();
        allTags.addAll(linkTags);
        allTags.addAll(podcastTags);

        allTags = allTags.stream().distinct().sorted().toList();

        model.addAttribute("tags", allTags);

        return "tags";
    }

}
