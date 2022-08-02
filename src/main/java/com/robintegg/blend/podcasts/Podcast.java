package com.robintegg.blend.podcasts;

import java.time.Instant;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Podcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feedUrl;
    private Instant dateAdded;
    @Embedded
    private FeedData feedData;
    @ElementCollection
    @CollectionTable(name = "link_tags", joinColumns = @JoinColumn(name = "link_id"))
    @Column(name="tags")
    private Set<String> tags;

}
