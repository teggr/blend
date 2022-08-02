package com.robintegg.blend.podcasts;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.rometools.modules.itunes.FeedInformation;
import com.rometools.rome.feed.module.Module;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
class PodcastMetadata {

    public FeedData getFeedData(String feedUrl) {

        log.info("reading podcast feed {}", feedUrl);

        try {

            String feedDataString = StreamUtils.copyToString(new URL(feedUrl).openStream(), StandardCharsets.UTF_8);

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(new ByteArrayInputStream(feedDataString.getBytes())));

            String webUrl = feed.getLink();
            String imageUrl = getImageUrl(feed);
            String title = feed.getTitle();
            String description = feed.getDescription();

            FeedData feedData = new FeedData(webUrl, imageUrl, title, description);

            log.info("read podcast feed for {}", title);

            return feedData;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    private static String getImageUrl(SyndFeed feed) throws MalformedURLException {

        if (feed.getImage() != null) {

            return feed.getImage().getUrl();

        } else {

            Module module = feed.getModule("http://www.itunes.com/dtds/podcast-1.0.dtd");

            if (module instanceof FeedInformation feedInformation) {

                if (feedInformation.getImage() != null) {

                    return feedInformation.getImage().toString();

                }

            }

            return null;
        }

    }

}
