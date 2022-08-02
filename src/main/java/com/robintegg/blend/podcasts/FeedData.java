package com.robintegg.blend.podcasts;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FeedData {
    
    @Column(name="feed_web_url")
    private String webUrl;
    @Column(name="feed_image_url")
    private String imageUrl;
    @Column(name="feed_title")
    private String title;
    @Column(name="feed_description")
    private String description;

}
