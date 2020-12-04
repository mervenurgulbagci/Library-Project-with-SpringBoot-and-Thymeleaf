package com.mnb.controller;

import com.mnb.entity.Publisher;
import com.mnb.service.PublisherService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/publisher")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublisherController {
    final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }


    @GetMapping("/list")
    public String listPublishers(Model theModel) {

        // get publisher from db
        List<Publisher> thePublishers = publisherService.findAll();

        // add to the spring model
        theModel.addAttribute("publishers", thePublishers);

        return "list-publishers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Publisher thePublisher = new Publisher();

        theModel.addAttribute("publishers", thePublisher);

        return "publisher-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("publisherId") int theID, Model theModel) {
        //get the publisher from the service
        Publisher thePublisher = publisherService.findById(theID);
        //set publisher as a model attribute to pre-populate the form
        theModel.addAttribute("publishers", thePublisher);
        return "publisher-form";
    }
    @PostMapping("/save")
    public String savePublisher(@ModelAttribute("publishers") Publisher thePublisher) {

        // save the publisher
        publisherService.save(thePublisher);

        // use a redirect to prevent duplicate submissions
        return "redirect:/publisher/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("publisherId") int theId) {

        // delete the book
        publisherService.deleteById(theId);

        // redirect to /publisher/list
        return "redirect:/publisher/list";

    }
}
