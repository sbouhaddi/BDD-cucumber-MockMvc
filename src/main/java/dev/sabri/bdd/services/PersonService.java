package dev.sabri.bdd.services;

import dev.sabri.bdd.mappers.PersonMapper;
import dev.sabri.bdd.repositories.PersonRepository;
import dev.sabri.bdd.web.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record PersonService(PersonRepository personRepository, PersonMapper personMapper) {

    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream().map(personMapper::toPersonDto).toList();
    }

    public PersonDto getPersonById(final long id) {
        return personRepository.findById(id).map(personMapper::toPersonDto).orElse(null);
    }

    public PersonDto createPerson(final PersonDto personDto) {
        return personMapper.toPersonDto(personRepository.save(personMapper.toPerson(personDto)));
    }

    public PersonDto updatePerson(final long id, final PersonDto personDto) {
        var foundPerson = personRepository.findById(id);
        if (foundPerson.isPresent()) {
            return personMapper.toPersonDto(personRepository.saveAndFlush(personMapper.toPerson(personDto)));
        }
        return null;
    }

    public void deletePerson(final long id) {
        personRepository.deleteById(id);
    }


}
