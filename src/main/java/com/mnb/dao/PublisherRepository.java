package com.mnb.dao;

import com.mnb.entity.Author;
import com.mnb.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
    //no need to any code
}
