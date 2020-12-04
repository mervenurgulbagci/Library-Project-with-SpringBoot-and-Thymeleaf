package com.mnb.dao;

import com.mnb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("Select b from Book b where b.book_name LIKE %?1%"
            + "OR b.isbn LIKE %?1%"
            + "OR b.serial_name LIKE %?1%"
            +"OR b.books_author LIKE %?1%")
    List<Book> findByName(String keyword);
}
