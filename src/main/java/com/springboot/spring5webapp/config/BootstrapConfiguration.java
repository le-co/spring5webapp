package com.springboot.spring5webapp.config;

import com.springboot.spring5webapp.domain.Author;
import com.springboot.spring5webapp.domain.Book;
import com.springboot.spring5webapp.repository.AuthorRepository;
import com.springboot.spring5webapp.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BootstrapConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    public BootstrapConfiguration(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void initApp() {
        Author author = new Author("Leandro", "Costa");
        Author authorSaved = this.authorRepository.save(author);

        Book book = new Book("Memories", "00000001", "IR PORT");
        book.addAuthor(author);

        Book bookSaved = bookRepository.save(book);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initApp();
    }
}
