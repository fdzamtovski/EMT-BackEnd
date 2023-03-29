package mk.ukim.finki.emt.backend.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.backend.model.Author;
import mk.ukim.finki.emt.backend.repository.AuthorRepository;
import mk.ukim.finki.emt.backend.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> listAuthors() {
        return this.authorRepository.findAll();
    }
}
