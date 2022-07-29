package com.robintegg.blend.links;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest.LinksRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LinksController {

    private final LinkRepository linkRepository;
    
    @GetMapping("/links")
    public String getLinks(Model model) {
        model.addAttribute("links", linkRepository.findAll());
        return "links";
    }

}
