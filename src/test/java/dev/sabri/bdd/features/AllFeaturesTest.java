package dev.sabri.bdd.features;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.*;

import java.io.File;

import static io.cucumber.junit.platform.engine.Constants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters(
        {
                @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber/cucumber.json"),
                @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "dev.sabri.bdd.features"),
                @ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")

        })
class AllFeaturesTest {

    @Test
    void testSuite() {
        final var bddResourcesDirectory = new File("src/test/resources/features");
        assertTrue(bddResourcesDirectory.exists());
    }
}
