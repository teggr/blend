package com.robintegg.blend.podcasts;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.robintegg.blend.tags.TagParser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddPodcastForm {

    @NotEmpty
    @Size(max = 2048)
    private String feedUrl;

    private String tags;

    public Set<String> getTagsAsSet() {
        return TagParser.parse(tags);
    }
    
}
