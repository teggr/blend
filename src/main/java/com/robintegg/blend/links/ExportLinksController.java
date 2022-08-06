package com.robintegg.blend.links;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ExportLinksController {

    private final LinkRepository linkRepository;

    @GetMapping(path = "/export-links", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String getExportLinks() {

        List<Link> findAll = linkRepository.findAll();

        StringBuilder b = new StringBuilder();

        b.append("url,title,description,tags,created\r\n");

        findAll.forEach(link -> {
            b.append(StringEscapeUtils.escapeCsv(link.getUrl()) + ",");
            b.append(StringEscapeUtils.escapeCsv(link.getTitle()) + ",");
            b.append(StringEscapeUtils.escapeCsv(link.getTags().stream().collect(Collectors.joining(","))) + ",");
            b.append(LocalDateTime.ofInstant(link.getDateAdded(), ZoneId.systemDefault()));
            b.append("\r\n");
        });

        return b.toString();

    }

}
