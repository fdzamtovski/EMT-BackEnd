package mk.ukim.finki.emt.backend.repository;

import mk.ukim.finki.emt.backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
