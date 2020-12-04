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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book-numarator")
    @SequenceGenerator(name = "book-numarator",  sequenceName = "BOOK_SEQ", allocationSize=1)
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
}
