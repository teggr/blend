package com.robintegg.blend.links;

import java.time.Instant;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddLinkController {

    private final LinkMetadata linkMetadata;
    private final LinkRepository linkRepository;

    @GetMapping("/add-link")
    public String getAddLink(
            @RequestParam(value = "url", required = true) String url,
            Model model) {

        String title = linkMetadata.getTitle(url);

        model.addAttribute("addLinkForm", new AddLinkForm(url, title, null));

        return "add-link";

    }

    @PostMapping("/add-link")
    public String postAddLink(
            @Valid @ModelAttribute AddLinkForm addLinkForm,
            BindingResult result) {

        linkRepository.save(new Link(null, addLinkForm.getUrl(), Instant.now(), addLinkForm.getTitle(), addLinkForm.getTagsAsSet()));

        return "redirect:/links";

    }

}
