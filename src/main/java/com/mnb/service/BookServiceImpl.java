package com.mnb.service;

import com.mnb.exception.NotFoundException;
import com.mnb.repository.BookRepository;
import com.mnb.entity.Book;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookServiceImpl implements BookService{
    final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        return bookRepository.findById(theId)
                .orElseThrow(() -> new NotFoundException(String.format(" not found  with ID %d", theId)));
    }

    @Override
    public void save(Book theBook) {
        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }

    @Override
    public List<Book> findBookByName(String keyword) {
        return bookRepository.findByName(keyword);
    }
}
