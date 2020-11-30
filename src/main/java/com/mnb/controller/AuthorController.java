package com.mnb.controller;

import com.mnb.entity.Author;
import com.mnb.service.AuthorService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/author")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorController {
    final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/list")
    public String listAuthors(Model theModel) {

        // get author from db
        List<Author> theAuthors = authorService.findAll();

        // add to the spring model
        theModel.addAttribute("authors", theAuthors);

        return "list-authors";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Author theAuthor = new Author();

        theModel.addAttribute("authors", theAuthor);

        return "authors/author-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("authorId") int theID, Model theModel) {
        //get the author from the service
        Author theAuthor = authorService.findById(theID);
        //set author as a model attribute to pre-populate the form
        theModel.addAttribute("authors", theAuthor);
        return "author-form";
    }
    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("authors") Author theAuthor) {

        // save the book
        authorService.save(theAuthor);

        // use a redirect to prevent duplicate submissions
        return "redirect:/author/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("authorId") int theId) {

        // delete the book
        authorService.deleteById(theId);

        // redirect to /author/list
        return "redirect:/author/list";

    }
}
