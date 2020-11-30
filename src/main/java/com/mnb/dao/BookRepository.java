package com.mnb.dao;

import com.mnb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    //no need to any code
}
