package com.robintegg.blend.links;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
class LinkMetadata {

    public String getTitle(String url) {

        try {
            
            // Get Document object after parsing the html from given url.
            Document document = Jsoup.connect(url).get();

            // Get title from document object.
            String title = document.title();

            return title;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
