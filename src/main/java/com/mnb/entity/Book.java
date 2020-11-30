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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
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
}
