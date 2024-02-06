package dev.sabri.bdd.features.actuator;

import io.cucumber.java.en.Given;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ActuatorStepDefs {
    protected final MockMvc mockMvc;

    public ActuatorStepDefs(MockMvc mockMvc) throws Exception {
        this.mockMvc = mockMvc;
    }

    @Given("application is up")
    public void applicationIsUp() throws Exception {
        mockMvc.perform(get("/api/v1/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
