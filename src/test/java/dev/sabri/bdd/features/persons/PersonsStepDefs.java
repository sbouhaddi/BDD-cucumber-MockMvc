package dev.sabri.bdd.features.persons;

import dev.sabri.bdd.features.utils.PersonUtils;
import dev.sabri.bdd.services.PersonService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonsStepDefs {
    protected final MockMvc mockMvc;
    protected final PersonService personService;
    private ResultActions resultActions;

    public PersonsStepDefs(MockMvc mockMvc, PersonService personService) {
        this.mockMvc = mockMvc;
        this.personService = personService;
    }

    @When("user makes a GET request to persons")
    public void userMakesAGetRequestToPersons() throws Exception {
        when(personService.getAllPersons()).thenReturn(PersonUtils.getPersonDtoList());
        resultActions = mockMvc.perform(get("/api/v1/persons"))
                .andDo(print());
    }

    @When("user makes a GET request to find person with id {int}")
    public void userMakesAGETRequestToFindPersonWithId(int personId) throws Exception {
        when(personService.getPersonById(personId)).thenReturn(PersonUtils.getPersonDtoList().getFirst());
        resultActions = mockMvc.perform(get("/api/v1/persons/" + personId))
                .andDo(print());
    }

    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) throws Exception {
        resultActions.andExpect(status().is(statusCode));
    }

    @And("response body is a list of {int} persons")
    public void responseBodySizeIs(int responseSize) throws Exception {
        resultActions.andExpect(jsonPath("$", hasSize(responseSize)));
    }

    @And("validate response body content")
    public void validateResponseBodyContent() throws Exception {
        resultActions.andExpect(jsonPath("$.firstName").value("John"));
    }

}
