package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domains.Author;
import guru.springframework.spring5webapp.domains.Book;
import guru.springframework.spring5webapp.domains.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book linux = new Book("Linux", "123123");
        eric.getBooks().add(linux);
        linux.getAuthors().add(eric);
        Publisher dea = new Publisher("Dea", "5 Road Closed", "London", "UK", "00000");

        authorRepository.save(eric);
        bookRepository.save(linux);
        publisherRepository.save(dea);

        System.out.println("Books in repo: " + authorRepository.count());
        System.out.println("Publishers in repo: " + publisherRepository.count());
    }
}
