package com.springboot.spring5webapp.controller;

import com.springboot.spring5webapp.domain.Book;
import com.springboot.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getBook(Model model) {
        List<Book> books = (List<Book>) this.bookRepository.findAll();
        model.addAttribute("books", books);
        return "books/index";
    }
}
