package com.robintegg.blend.aggregate;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;

@Entity
@Immutable
@Getter
public class AggregatedContent {

    @Id
    private Long id;
    private Instant dateAdded;
    private String contentType;

}
