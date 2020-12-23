package com.learning.springwebapp.bootstrap;

import com.learning.springwebapp.domain.Author;
import com.learning.springwebapp.domain.Book;
import com.learning.springwebapp.repositories.AuthorRepository;
import com.learning.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        // Save objects into the repository
        this.authorRepository.save(lovecraft);
        this.authorRepository.save(ito);
        this.bookRepository.save(dagon);
        this.bookRepository.save(uzumaki);

        System.out.println("Data Bootstrap");
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
    }
}
