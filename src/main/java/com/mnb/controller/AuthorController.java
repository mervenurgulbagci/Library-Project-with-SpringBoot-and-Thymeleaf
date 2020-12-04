package com.mnb.controller;

import com.mnb.entity.Author;
import com.mnb.entity.Book;
import com.mnb.service.AuthorService;
import com.mnb.service.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/author")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorController {

    public static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    final BookService bookService;
    final AuthorService authorService;

    public AuthorController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
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
        return "author-form";
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
        // save the author
        authorService.save(theAuthor);
        // use a redirect to prevent duplicate submissions
        return "redirect:/author/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("authorId") int theId) {
        // delete the author
        authorService.deleteById(theId);
        // redirect to /author/list
        return "redirect:/author/list";
    }
/*
    @GetMapping("/viewAuthor/{authorId}")
    public ModelAndView viewAuthor(ModelAndView modelAndView, @PathVariable int authorId) {

        logger.debug("GETTER VIEW AUTHOR id: " + authorId);
        if (authorService.getAuthor(authorId).isPresent()) {
            Author author = authorService.getAuthor(authorId).get();
            modelAndView.addObject("title", author.getAuthor_name());
            modelAndView.addObject("books", author.getBooksList());
            modelAndView.addObject("authorId", author.getId());
            modelAndView.setViewName("author/viewAuthor");
        } else {
            modelAndView.setViewName("redirect:/list_authors/");
        }
        return modelAndView;
    }

    @GetMapping("/addBook/{authorId}")
    public ModelAndView addBooks(ModelAndView modelAndView, @PathVariable Integer authorId) {
        logger.debug("GETTER ADD BOOK id: " + authorId);
        if (authorService.getAuthor(authorId).isPresent()) {
            Author author = authorService.getAuthor(authorId).get();
            AddBookForm form = new AddBookForm(bookService.getAllBooks(), author);
            modelAndView.addObject("title", "Add Books to " + author.getAuthor_name());
            modelAndView.addObject("form", form);
            modelAndView.addObject("success", true);
            modelAndView.setViewName("addBook");
        } else {
            modelAndView.setViewName("redirect:/list_authors");
            modelAndView.addObject("success", false);
        }
        return modelAndView;
    }

    @PostMapping("/addBook")
    public ModelAndView addBook(ModelAndView modelAndView, @ModelAttribute @Valid AddBookForm addBookForm, Errors errors){
        logger.debug("POST ADD BOOK");
        if (errors.hasErrors()){
            modelAndView.addObject("form", addBookForm);
            modelAndView.setViewName("addBook");
            return modelAndView;
        }
        if(bookService.getBook(addBookForm.getBookId()).isPresent() && authorService.getAuthor(addBookForm.getAuthorId()).isPresent()) {
            Book book = bookService.getBook(addBookForm.getBookId()).get();
            Author author = authorService.getAuthor(addBookForm.getAuthorId()).get();
            authorService.addBook(author,book);
        }

        return modelAndView;
    }
    */


}
