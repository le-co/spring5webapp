package com.springboot.spring5webapp.config;

import com.springboot.spring5webapp.domain.Address;
import com.springboot.spring5webapp.domain.Author;
import com.springboot.spring5webapp.domain.Book;
import com.springboot.spring5webapp.domain.Publisher;
import com.springboot.spring5webapp.repository.AuthorRepository;
import com.springboot.spring5webapp.repository.BookRepository;
import com.springboot.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BootstrapConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public BootstrapConfiguration(AuthorRepository authorRepository, BookRepository bookRepository,
                                  PublisherRepository publisherRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void initApp() {
        Author author = new Author("Leandro", "Costa");
        Author authorSaved = this.authorRepository.save(author);

        Address address = new Address();
        address.setCity("Barueri");
        address.setDistrict("Jardim Tupanci");
        address.setState("Sao Paulo");
        address.setStreet("Rua Marte");
        address.setZipCode("0000000");

        Publisher publisher = new Publisher();

        publisher.setName("IR PORT");
        publisher.setAddress(address);

        Publisher publiserSaved = this.publisherRepository.save(publisher);

        Book book = new Book("Memories", "00000001", publiserSaved);
        book.addAuthor(author);

        Book bookSaved = bookRepository.save(book);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initApp();
    }
}
