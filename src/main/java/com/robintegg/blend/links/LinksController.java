package com.robintegg.blend.links;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LinksController {

    private final LinkRepository linkRepository;

    @GetMapping("/links")
    public String getLinks(Model model, @PageableDefault(sort = "dateAdded", direction = Direction.DESC, size = 3) Pageable pageable) {
        model.addAttribute("links", linkRepository.findAll(pageable));
        return "links";
    }

}
