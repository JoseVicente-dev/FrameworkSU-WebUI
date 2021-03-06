package co.com.client.webproject.test.runners.contactus;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/contactUs.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition"},
        tags = "@ScenarioName:contactarConServicioAlCliente",
        publish = true)
public class ContactarConServicioAlClienteTest {
}
