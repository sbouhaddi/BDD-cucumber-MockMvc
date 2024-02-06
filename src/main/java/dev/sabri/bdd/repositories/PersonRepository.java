package dev.sabri.bdd.repositories;

import dev.sabri.bdd.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
