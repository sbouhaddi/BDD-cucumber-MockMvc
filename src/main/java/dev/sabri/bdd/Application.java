package dev.sabri.bdd;

import dev.sabri.bdd.domain.Person;
import dev.sabri.bdd.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner bootstrapPerson(PersonRepository personRepository) {
        return args -> {
            personRepository.save(new Person( "John", "Doe", "<EMAIL>", "",""));
            personRepository.save(new Person( "Jane", "Doe", "<EMAIL>","",""));
            System.out.println(personRepository.findAll().size());
        };
    }

}
