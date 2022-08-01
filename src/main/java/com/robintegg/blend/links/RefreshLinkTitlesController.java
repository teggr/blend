package com.robintegg.blend.links;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RefreshLinkTitlesController {
    
    private final LinkRepository linkRepository;
    private final LinkMetadata linkMetadata;

    @GetMapping("/refresh-link-titles")
    public String getRefreshLinkTitles(Model model) {
        model.addAttribute("emptyOnlyCount", linkRepository.countByTitleIsNull());
        return "refresh-link-titles";
    }

    @PostMapping(path = "/refresh-link-titles", params = "emptyOnly")
    public String postRefreshEmptyLinkTitles() {

        List<Link> findAll = linkRepository.findAllByTitleIsNull();

        for (Link link : findAll) {
            
            link.updateTitle(linkMetadata.getTitle(link.getUrl()));
            linkRepository.save(link);

        }

        return "redirect:/links";
    }

}
