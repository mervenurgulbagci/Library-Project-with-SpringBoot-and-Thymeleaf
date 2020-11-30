package com.mnb.dao;

import com.mnb.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    //no need to any code
}
