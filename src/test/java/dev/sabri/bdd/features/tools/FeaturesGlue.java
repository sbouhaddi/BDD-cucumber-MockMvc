package dev.sabri.bdd.features.tools;

import dev.sabri.bdd.repositories.PersonRepository;
import dev.sabri.bdd.services.PersonService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@CucumberContextConfiguration
@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
public class FeaturesGlue {

    @MockBean
    private PersonRepository personRepository;
    @MockBean
    private PersonService personService;
}
