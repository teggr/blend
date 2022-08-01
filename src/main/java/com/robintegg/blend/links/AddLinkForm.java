package com.robintegg.blend.links;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddLinkForm {

    @NotEmpty
    @Size(max = 2048)
    private String url;

    @NotEmpty
    @Size(max = 2048)
    private String title;

    private String tags;

    public Set<String> getTagsAsSet() {
        return tags == null ? Set.of() : Stream.of(tags.split(",")).map(String::trim).collect(Collectors.toSet());
    }

}
