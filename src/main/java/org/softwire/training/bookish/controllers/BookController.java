package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.BookPageModel;
import org.softwire.training.bookish.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("")
    ModelAndView showBooks(@RequestParam(required = false) String searchString) {

        if(searchString == null){
            searchString = "";
        }
        List<Book> foundBooks = bookService.searchBooks(searchString);

        BookPageModel bookPageModel = new BookPageModel();
        bookPageModel.setBooks(foundBooks);

        return new ModelAndView("book", "model", bookPageModel);
    }
}
