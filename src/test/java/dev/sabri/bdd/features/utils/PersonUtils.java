package dev.sabri.bdd.features.utils;

import dev.sabri.bdd.web.dto.PersonDto;

import java.util.List;

public class PersonUtils {
    private PersonUtils() {
    }

    public static List<PersonDto> getPersonDtoList() {
        return List.of(new PersonDto("John", "Doe", "<EMAIL>", "", ""),
                new PersonDto("Jane", "Doe", "<EMAIL>", "", ""));
    }


}
