package mk.ukim.finki.emt.backend.web;

import mk.ukim.finki.emt.backend.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/categories")
public class CategoryRestController {

    @GetMapping
    public List<Category> listCategories() {
        return Arrays.asList(Category.values());
    }
}
