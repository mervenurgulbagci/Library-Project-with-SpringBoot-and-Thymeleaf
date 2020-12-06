package com.mnb.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;
    @Column(name = "BOOK_NAME")
    String book_name;
    @Column(name = "BOOK_SUBNAME")
    String book_subname;
    @Column(name = "BOOK_SERIAL_NAME")
    String serial_name;
    @Column(name = "BOOKS_AUTHOR")
    String books_author;
    @Column(name = "BOOKS_PUBLISHER")
    String books_publisher;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "ISBN")
    String isbn;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "AUTHOR_ID")
    Author author;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_subname() {
        return book_subname;
    }

    public void setBook_subname(String book_subname) {
        this.book_subname = book_subname;
    }

    public String getSerial_name() {
        return serial_name;
    }

    public void setSerial_name(String serial_name) {
        this.serial_name = serial_name;
    }

    public String getBooks_author() {
        return books_author;
    }

    public void setBooks_author(String books_author) {
        this.books_author = books_author;
    }

    public String getBooks_publisher() {
        return books_publisher;
    }

    public void setBooks_publisher(String books_publisher) {
        this.books_publisher = books_publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
