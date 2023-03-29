package mk.ukim.finki.emt.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.backend.model.enumerations.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;
}