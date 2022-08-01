package com.robintegg.blend.links;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface LinkRepository extends JpaRepository<Link,Long> {

    List<Link> findAllByTitleIsNull();

    int countByTitleIsNull();

}
