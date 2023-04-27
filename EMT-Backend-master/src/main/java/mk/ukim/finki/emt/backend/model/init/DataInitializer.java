package mk.ukim.finki.emt.backend.model.init;


import mk.ukim.finki.emt.backend.model.Author;
import mk.ukim.finki.emt.backend.model.Country;
import mk.ukim.finki.emt.backend.model.enumerations.Category;
import mk.ukim.finki.emt.backend.service.AuthorService;
import mk.ukim.finki.emt.backend.service.BookService;
import mk.ukim.finki.emt.backend.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private  final CountryService countryService;
    private final BookService bookService;
    private final AuthorService authorService;

    public DataInitializer(CountryService countryService, BookService bookService, AuthorService authorService) {
        this.countryService = countryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void initData()
    {
        Country country=this.countryService.create("Macedonia","Europe");
        Author author=this.authorService.create("Author1","surname",country);
        this.bookService.create("Book1", Category.DRAMA,author,2);
        this.bookService.create("Book2",Category.BIOGRAPHY,author,3);

    }
}