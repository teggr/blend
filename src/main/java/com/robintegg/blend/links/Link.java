package com.robintegg.blend.links;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.ocpsoft.prettytime.PrettyTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private Instant dateAdded;


    public String getDurationSinceDateAdded() {
        PrettyTime p = new PrettyTime();
        return p.format(dateAdded);
    }

}
