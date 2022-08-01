package com.robintegg.blend.tags;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TagParser {

    public static Set<String> parse(String tags) {
        if (tags == null) {
            return Set.of();
        }
        return Stream.of(tags.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());
    }

}
