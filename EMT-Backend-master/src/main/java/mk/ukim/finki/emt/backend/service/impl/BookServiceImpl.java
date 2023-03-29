package mk.ukim.finki.emt.backend.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.backend.model.Author;
import mk.ukim.finki.emt.backend.model.Book;
import mk.ukim.finki.emt.backend.model.dto.BookDto;
import mk.ukim.finki.emt.backend.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.backend.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.backend.repository.AuthorRepository;
import mk.ukim.finki.emt.backend.repository.BookRepository;
import mk.ukim.finki.emt.backend.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> listBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> listBooksPaginated(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);
        return Optional.of(this.bookRepository
                .save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> take(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        int copies;
        if (book.getAvailableCopies() > 0) {
            copies = book.getAvailableCopies() - 1;
        } else {
            copies = book.getAvailableCopies();
        }
        book.setAvailableCopies(copies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}