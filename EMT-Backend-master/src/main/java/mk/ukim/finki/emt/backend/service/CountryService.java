package mk.ukim.finki.emt.backend.service;

import mk.ukim.finki.emt.backend.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findByName(String name);
    Optional<Country> findById(Long id);

    Country create(String name, String continent);
    void deleteByName(String name);

}

