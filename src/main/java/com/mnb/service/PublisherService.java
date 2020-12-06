package com.mnb.service;

import com.mnb.entity.Author;
import com.mnb.entity.Publisher;

import java.util.List;

public interface PublisherService {
    public List<Publisher> findAll();

  public Publisher findById(int theId);

    public void save(Publisher thePublisher);

    public void deleteById(int theId);
}
