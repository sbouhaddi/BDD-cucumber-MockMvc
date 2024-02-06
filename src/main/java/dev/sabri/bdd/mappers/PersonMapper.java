package dev.sabri.bdd.mappers;

import dev.sabri.bdd.domain.Person;
import dev.sabri.bdd.web.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto toPersonDto(Person person);

    Person toPerson(PersonDto personDto);
}
