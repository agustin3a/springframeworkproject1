package com.learning.springwebapp.bootstrap;

import com.learning.springwebapp.domain.Author;
import com.learning.springwebapp.domain.Book;
import com.learning.springwebapp.domain.Publisher;
import com.learning.springwebapp.repositories.AuthorRepository;
import com.learning.springwebapp.repositories.BookRepository;
import com.learning.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Generate objects
        Author lovecraft = new Author("H.P.","Lovecraft");
        Book dagon = new Book("Dagon","123456789");
        lovecraft.getBooks().add(dagon);
        dagon.getAuthors().add(lovecraft);

        Author ito = new Author("Junji","Ito");
        Book uzumaki = new Book("Uzumaki","123456780");
        ito.getBooks().add(uzumaki);
        uzumaki.getAuthors().add(ito);

        Publisher viz = new Publisher("Viz","220 STE","Miami","Florida","33012");

        // Save objects into the repository
        this.authorRepository.save(lovecraft);
        this.authorRepository.save(ito);
        this.bookRepository.save(dagon);
        this.bookRepository.save(uzumaki);
        this.publisherRepository.save(viz);

        System.out.println("Data Bootstrap");
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
