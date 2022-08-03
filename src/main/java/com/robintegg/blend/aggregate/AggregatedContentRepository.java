package com.robintegg.blend.aggregate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AggregatedContentRepository extends JpaRepository<AggregatedContent,Long> {
    
}
