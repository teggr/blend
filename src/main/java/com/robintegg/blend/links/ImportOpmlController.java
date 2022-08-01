package com.robintegg.blend.links;

import java.time.Instant;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.robintegg.blend.tags.TagParser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ImportOpmlController {

    private final LinkRepository linkRepository;

    @GetMapping("/import-opml")
    public String getImportOpml() {
        return "import-opml";
    }

    @PostMapping("/import-opml")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        try {
            Document document = Jsoup.parse(file.getInputStream(), "utf-8", "");

            Elements elementsByTag = document.getElementsByTag("a");

            log.info("found {} opml entries", elementsByTag.size());

            elementsByTag.forEach((el)->{

                String linkHref = el.attr("href"); // "http://example.com/"
                String linkText = el.text(); // "example""
                String linkTimeAdded = el.attr("time_added"); // "1518351625"
                String linkTags = el.attr("tags"); // "agile,testing"

                Link link = new Link(null, linkHref, Instant.ofEpochSecond(Long.valueOf(linkTimeAdded)), linkText, TagParser.parse(linkTags));

                linkRepository.save(link);

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/links";
    }

}
