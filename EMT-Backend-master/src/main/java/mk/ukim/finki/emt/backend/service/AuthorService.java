package mk.ukim.finki.emt.backend.service;

import mk.ukim.finki.emt.backend.model.Author;
import mk.ukim.finki.emt.backend.model.Book;
import mk.ukim.finki.emt.backend.model.Country;
import mk.ukim.finki.emt.backend.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();


    Author create(String author1, String surname, Country country);
}
