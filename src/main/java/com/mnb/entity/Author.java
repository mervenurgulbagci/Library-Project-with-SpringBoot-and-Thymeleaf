package com.mnb.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    Integer id;
    @Column(name = "AUTHOR_NAME")
    String author_name;
    @Column(name = "DESCRIPTION")
    String description;
}
