package com.mnb.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;
    @Column(name = "AUTHOR_NAME")
    String author_name;
    @Column(name = "DESCRIPTION")
    String description;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "author",
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    List<Book> booksList=new ArrayList<Book>();

    public void add(Book tempBook){
        if (booksList==null){
            booksList=new ArrayList<>();
        }
        // this is bi-directional relationship
        booksList.add(tempBook);
        tempBook.setAuthor(this);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }
}
