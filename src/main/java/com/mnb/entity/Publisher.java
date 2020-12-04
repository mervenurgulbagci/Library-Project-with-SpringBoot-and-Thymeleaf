package com.mnb.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "PUBLISHER")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher-numarator")
    @SequenceGenerator(name = "publisher-numarator",  sequenceName = "PUBLISHER_SEQ", allocationSize=1)
    @Column(name = "ID")
    Integer id;
    @Column(name = "PUBLISHER_NAME")
    String publisher_name;
    @Column(name = "DESCRIPTION")
    String description;
}
